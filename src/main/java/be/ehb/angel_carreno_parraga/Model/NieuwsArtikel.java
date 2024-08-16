package be.ehb.angel_carreno_parraga.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.GenerationType;

@Entity
public class NieuwsArtikel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Long wordt beter ondersteund dan gewoon een int JPA
    private Long id;

    private String titel;
    private String categorie;
    private String inhoud;
    private String naamReporter;
    private String emailReporter;

    //Getters en setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getInhoud() {
        return inhoud;
    }

    public void setInhoud(String inhoud) {
        this.inhoud = inhoud;
    }

    public String getNaamReporter() {
        return naamReporter;
    }

    public void setNaamReporter(String naamReporter) {
        this.naamReporter = naamReporter;
    }

    public String getEmailReporter() {
        return emailReporter;
    }

    public void setEmailReporter(String emailReporter) {
        this.emailReporter = emailReporter;
    }
}
