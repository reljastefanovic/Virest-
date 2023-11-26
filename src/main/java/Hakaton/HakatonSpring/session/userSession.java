package Hakaton.HakatonSpring.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class userSession {

    private boolean loggedIn;
    private Long userId;

    public void login() {
        this.loggedIn = true;
    }

    public void logout() {
        this.loggedIn = false;
        this.userId = null;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

