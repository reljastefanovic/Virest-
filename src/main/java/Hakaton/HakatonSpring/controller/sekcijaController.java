package Hakaton.HakatonSpring.controller;

import Hakaton.HakatonSpring.model.sekcijaEntitet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class sekcijaController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @GetMapping("/fetch-sekcija")
    @CrossOrigin
    public Map<String, List<sekcijaEntitet>> fetchData() {
        String sql = "SELECT * FROM SEKCIJA";
        List<sekcijaEntitet> sekcijaEntitets = jdbcTemplate.query(
                sql,
                (resultSet, rowNum) -> {
                    sekcijaEntitet sekcijaEntitet = new sekcijaEntitet();
                    sekcijaEntitet.setNaziv(resultSet.getString("naziv"));
                    return sekcijaEntitet;

                }
        );

        Map<String, List<sekcijaEntitet>> responseMap = new HashMap<>();
        responseMap.put("sekcije", sekcijaEntitets);
        return responseMap;
    }

}
