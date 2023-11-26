package Hakaton.HakatonSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import Hakaton.HakatonSpring.service.userService;
import Hakaton.HakatonSpring.session.userSession;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class korisnikController {

    private final userService userService;
    private final userSession userSession;

    @Autowired
    public korisnikController(userService userService, userSession userSession) {
        this.userService = userService;
        this.userSession = userSession;
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        Long userId = userService.authenticateUser(username, password);

        if (userId != null) {
            userSession.login();
            userSession.setUserId(userId);
            System.out.println("Prijavili ste se kao: " + username);
            return "redirect:/pocetnaforum.html?success=1";
        } else {
            // Neuspesna prijava
            return "redirect:/login.html?error=1";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        userSession.logout();
        System.out.println("Odjavili ste se sa profila.");
        return "redirect:/pocetnaforum.html?logout=1";
    }

    @PostMapping("/register")
    public String registerUser(
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("password") String password) {


        userService.registerUser(username, email, password);


        return "redirect:/login.html";
    }
}
