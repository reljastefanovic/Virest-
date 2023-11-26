package Hakaton.HakatonSpring.controller;
import Hakaton.HakatonSpring.repository.temaRepository;
import Hakaton.HakatonSpring.model.komentarEntitet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class temaController1 {
    private final temaRepository temaRepository;
    @Autowired
    public temaController1(temaRepository entity) {
        this.temaRepository = entity;
    }
    @RequestMapping(value="/submit",method = RequestMethod.POST)
    public String handleFormSubmission(@ModelAttribute komentarEntitet teme, HttpServletRequest request) {
        temaRepository.save(teme);
        System.out.println("Treba da upise u bazu");
        String sectionIdParam = request.getParameter("sekcija_id");


        int sectionId = Integer.parseInt(sectionIdParam);
        System.out.println(sectionId);


        String redirectPath = String.format("redirect:/sekcija%d.html", sectionId);
        return redirectPath;


    }
}
