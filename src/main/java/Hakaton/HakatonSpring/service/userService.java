package Hakaton.HakatonSpring.service;

import Hakaton.HakatonSpring.model.korisnikEntitet;
import Hakaton.HakatonSpring.repository.korisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class userService {

    private final JdbcTemplate jdbcTemplate;
    private final korisnikRepository userRepository;
    private  Long id;
    private String username;


    @Autowired
    public userService(JdbcTemplate jdbcTemplate, korisnikRepository userRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRepository = userRepository;
    }

    public Long authenticateUser(String username, String password) {
        String sql = "SELECT id, username, password FROM KORISNIK WHERE username = ?";
        try {
            korisnikEntitet user = jdbcTemplate.queryForObject(sql, (resultSet, rowNum) -> {
                korisnikEntitet u = new korisnikEntitet();
                u.setId(resultSet.getLong("id"));
                u.setUsername(resultSet.getString("username"));
                u.setPassword(resultSet.getString("password"));
                return u;
            }, username);

            if (user != null && verifyPassword(password, user.getPassword())) {
                setAuthenticatedUserId(user.getId());
                setAuthenticatedUsername(user.getUsername());
                System.out.println("User authenticated. ID: " + user.getId() + ", Username: " + user.getUsername());
                return user.getId();
            }
        } catch (Exception e) {
            return null;
        }

        return null;
    }

    public void registerUser(String username, String email, String password) {

        korisnikEntitet newUser = new korisnikEntitet();
        newUser.setUsername(username);
        newUser.setEmail(email);


        String hashedPassword = hashPassword(password);
        newUser.setPassword(hashedPassword);

        userRepository.insertUser(newUser);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));


            StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    private boolean verifyPassword(String enteredPassword, String hashedPassword) {

        return hashPassword(enteredPassword).equals(hashedPassword);
    }
    public Long getAuthenticatedUserId() {
        Long userId = id;
        System.out.println("Getting authenticated user ID: " + userId);
        return userId;
    }

    private void setAuthenticatedUserId(Long userId) {

        this.id=userId;
    }
    public String getAuthenticatedUsername() {
        String authenticatedUsername = username;
        System.out.println("Getting authenticated username: " + authenticatedUsername);
        return authenticatedUsername;
    }

    private void setAuthenticatedUsername(String username) {

        this.username = username;
    }


}
