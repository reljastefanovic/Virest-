package Hakaton.HakatonSpring.repository;
import Hakaton.HakatonSpring.model.komentarEntitet;
import Hakaton.HakatonSpring.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class temaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private userService userService;

    public void save(komentarEntitet teme){
        Long authenticatedUserId = userService.getAuthenticatedUserId();
        String username=userService.getAuthenticatedUsername();
        String sql="INSERT INTO KOMENTARI(korisnik_username, sekcija_id,komentar) VALUES (?,?,?)";
        jdbcTemplate.update(sql,username,teme.getSekcija_id(),teme.getKomentar());

    }

}
