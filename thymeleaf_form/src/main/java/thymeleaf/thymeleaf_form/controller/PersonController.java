package thymeleaf.thymeleaf_form.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import thymeleaf.thymeleaf_form.repository.PersonDao;

@Controller

@RequestMapping("")
public class PersonController {
    @Autowired
    private PersonDao personDao;
    @GetMapping("getAll")
    public String listAll(Model model) {
        model.addAttribute("person", personDao.getAll());
        return "allbooks";
    }
    
}
