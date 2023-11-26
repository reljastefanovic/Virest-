package Hakaton.HakatonSpring.repository;

import Hakaton.HakatonSpring.model.sekcijaEntitet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class sekcijaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(sekcijaEntitet sekcije){
        String sql="INSERT INTO SEKCIJA(naziv) VALUES (?)";
        jdbcTemplate.update(sql,sekcije.getNaziv());

    }
}
