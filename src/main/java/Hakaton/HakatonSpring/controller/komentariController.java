package Hakaton.HakatonSpring.controller;
import Hakaton.HakatonSpring.model.komentarEntitet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class komentariController {
        @Autowired
        private JdbcTemplate jdbcTemplate;
        @GetMapping("/fetch-komentar")
        @CrossOrigin
        public Map<String, List<komentarEntitet>> fetchData() {
            String sql = "SELECT * FROM KOMENTARI";
            List<komentarEntitet> komentarEntitets = jdbcTemplate.query(
                    sql,
                    (resultSet, rowNum) -> {
                        komentarEntitet komentarEntitet = new komentarEntitet();
                        komentarEntitet.setId(resultSet.getLong("id"));
                        komentarEntitet.setKorisnik_username(resultSet.getString("korisnik_username"));
                        komentarEntitet.setSekcija_id(resultSet.getLong("sekcija_id"));
                        komentarEntitet.setKomentar(resultSet.getString("Komentar"));
                        return komentarEntitet;

                    }
            );

            Map<String, List<komentarEntitet>> responseMap = new HashMap<>();
            responseMap.put("komentari", komentarEntitets);
            return responseMap;
        }
}
