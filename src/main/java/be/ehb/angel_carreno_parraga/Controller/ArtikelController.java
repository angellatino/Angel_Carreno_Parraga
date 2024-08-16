package be.ehb.angel_carreno_parraga.Controller;

import be.ehb.angel_carreno_parraga.DAO.NieuwsArtikelDAO;
import be.ehb.angel_carreno_parraga.Model.NieuwsArtikel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

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
        return repo.findLast10();
    }

    @ModelAttribute("nieuw_nieuwsartikel")
    public NieuwsArtikel maakNieuweNieuwsArtikel(){
        return new NieuwsArtikel();
    }

    ////Met deze methode roepen we de "Index" pagina aan
    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String showIndex(Model map){
        return "index";
    }

    //Met deze methode roepen we de "New" pagina aan
    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String showNew(Model map){
        return "new";
    }


    ////Met deze methode roepen we de "About" pagina aan
    //heeft geen "(Modelmap map)" nodig als parameter omdat deze pagina statish is
    @RequestMapping(value = {"/about"}, method = RequestMethod.GET)
    public String showAbout(){
        return "about";
    }

    //Met deze methode roepen we de "Detail" pagina aan
    @RequestMapping(value = {"/details/{id}"}, method = RequestMethod.GET)
    public String showDetails(@PathVariable("id") Long id, Model model) {
        Optional<NieuwsArtikel> artikel = repo.findById(id);
        if (artikel.isPresent()) {
            model.addAttribute("artikel", artikel.get());
            return "details";
        } else {
            // Als het artikel niet gevonden is, redirect naar de index pagina of toon een errorpagina
            return "redirect:/Index";
        }
    }


    @RequestMapping(value = {"/New"}, method = RequestMethod.POST)
    public String saveNieuwsArtikel(@ModelAttribute("nieuw_nieuwsartikel") NieuwsArtikel nieuweNieuwsArtikel, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "new";
        }
        repo.save(nieuweNieuwsArtikel);
        return "redirect:/Index";
    }



}
