package be.ehb.angel_carreno_parraga.DAO;

import be.ehb.angel_carreno_parraga.Model.NieuwsArtikel;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface NieuwsArtikelDAO extends JpaRepository<NieuwsArtikel, Long> {

    //Enkel de  10 laatste artikels worden opgevraagd, dus een lijst van 10 artikels.
    default Iterable<NieuwsArtikel> findLast10() {
            Pageable limit = PageRequest.of(0, 10);
            return findAll(limit).getContent();
        }


    }

