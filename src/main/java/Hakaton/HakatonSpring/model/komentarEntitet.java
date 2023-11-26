package Hakaton.HakatonSpring.model;

import jakarta.persistence.Id;

public class komentarEntitet {
    @Id
    private Long id;
    private String korisnik_username;
    private Long sekcija_id;
    private String komentar;





    public komentarEntitet(){

    }

    public komentarEntitet(Long id, String korisnik_id, Long sekcija_id, String naslov) {
        this.id = id;
        this.korisnik_username=korisnik_id;
        this.sekcija_id = sekcija_id;
        this.komentar = naslov;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSekcija_id() {
        return sekcija_id;
    }

    public void setSekcija_id(Long sekcija_id) {
        this.sekcija_id = sekcija_id;
    }

    public String getKorisnik_username() {
        return korisnik_username;
    }

    public void setKorisnik_username(String korisnik_username) {
        this.korisnik_username = korisnik_username;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }
}
