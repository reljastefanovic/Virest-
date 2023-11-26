package Hakaton.HakatonSpring.repository;

import Hakaton.HakatonSpring.model.korisnikEntitet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class korisnikRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public korisnikRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public korisnikEntitet findByEmail(String email) {
        String sql = "SELECT * FROM KORISNIK WHERE email = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{email}, this::mapRowToUser);
    }

    public korisnikEntitet findByUsernameAndPass(String username, String pass) {
        String sql = "SELECT * FROM KORISNIK WHERE username = ? AND pass = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username, pass}, this::mapRowToUser);
    }
    public void insertUser(korisnikEntitet user) {
        String sql = "INSERT INTO KORISNIK (username, password, email) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail());
        System.out.println("USPESNO REGISTROVAN UNOS HAHAHA PRENK PRENK");
    }

    public korisnikEntitet findByUsername(String username) {
        String sql = "SELECT * FROM KORISNIK WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username}, this::mapRowToUser);
    }

    public List<korisnikEntitet> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, this::mapRowToUser);
    }

    private korisnikEntitet mapRowToUser(ResultSet rs, int rowNum) throws SQLException {
        korisnikEntitet user = new korisnikEntitet();
        user.setId(rs.getLong("id"));
        user.setEmail(rs.getString("email"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("pass"));

        return user;
    }


}
