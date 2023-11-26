package Hakaton.HakatonSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class bazatest {
        private final JdbcTemplate jdbcTemplate;

        @Autowired
        public bazatest(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

        public void testConnection() {
            try {
                String result = jdbcTemplate.queryForObject("SELECT 1", String.class);
                System.out.println("Database Connection Test Successful: " + result);
            } catch (Exception e) {
                System.err.println("Database Connection Test Failed: " + e.getMessage());
            }
        }

    }

