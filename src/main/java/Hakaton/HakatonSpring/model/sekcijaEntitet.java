package Hakaton.HakatonSpring.model;

import jakarta.persistence.Id;

public class sekcijaEntitet {
    @Id
    private Long id;
    private String naziv;

    public sekcijaEntitet() {
    }

    public sekcijaEntitet(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
