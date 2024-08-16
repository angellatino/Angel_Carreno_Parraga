package be.ehb.angel_carreno_parraga.Model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.persistence.GenerationType;

@Entity
public class NieuwsArtikel {

    @Id
    @GenericGenerator(
            name = "students-sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "artikels_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "0"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            })
    //Long wordt beter ondersteund dan gewoon een int JPA
    @GeneratedValue(generator = "artikels-sequence-generator")
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
