package be.ehb.angel_carreno_parraga.Controller;

import be.ehb.angel_carreno_parraga.DAO.NieuwsArtikelDAO;
import be.ehb.angel_carreno_parraga.Model.NieuwsArtikel;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/Index")
public class ArtikelController {

    @Autowired
    private NieuwsArtikelDAO repo;

    public ArtikelController(NieuwsArtikelDAO repo) {
        this.repo = repo;
    }
    @ModelAttribute("Index")
    public Iterable<NieuwsArtikel> findAll(){
        return repo.findAll();
    }

    @ModelAttribute("nieuw_nieuwsartikel")
    public NieuwsArtikel maakNieuweNieuwsArtikel(){
        return new NieuwsArtikel();
    }

    ////Met deze methode roepen we de "Index" pagina aan
    @RequestMapping(value = {"/", "Index"}, method = RequestMethod.GET)
    public String showIndex(Model map){
        return "index";
    }

    //Met deze methode roepen we de "New" pagina aan
    @RequestMapping(value = {"/New"}, method = RequestMethod.GET)
    public String showNew(Model map){
        return "new";
    }

    //Met deze methode roepen we de "Detail" pagina aan
    @RequestMapping(value = {"/Details"}, method = RequestMethod.GET)
    public String showDetails(Model map){
        return "details";
    }

    ////Met deze methode roepen we de "About" pagina aan
    //heeft geen "(Modelmap map)" nodig als parameter omdat deze pagina statish is
    @RequestMapping(value = {"/About"}, method = RequestMethod.GET)
    public String showAbout(){
        return "about";
    }


    @RequestMapping(value = {"/New"}, method = RequestMethod.POST)
    public String saveNieuwsArtikel(@ModelAttribute("nieuw_nieuwsartikel") @Valid NieuwsArtikel nieuweNieuwsArtikel, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "new";
        }
        repo.save(nieuweNieuwsArtikel);
        return "redirect:/Index";
    }


}
