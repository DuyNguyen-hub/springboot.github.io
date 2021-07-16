package com.spring.thymeleaf_form_ex06.controller;

import com.spring.thymeleaf_form_ex06.model.Person;
import com.spring.thymeleaf_form_ex06.repository.PersonInterface;
import com.spring.thymeleaf_form_ex06.repository.PersonRepo;
import com.spring.thymeleaf_form_ex06.request.SearchRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
@Slf4j
public class PersonController {
    @Autowired
    private PersonInterface personDao;

    @GetMapping("")
    public String getAll(Model model, @ModelAttribute SearchRequest searchRequest) {
//        log.info(searchRequest.getKeyword());
        List<Person> list = null;
        if (searchRequest.getKeyword() == null) {
            list = personDao.getAll();
        }else {
            list = personDao.searchByKeyword(searchRequest.getKeyword());
        }
        model.addAttribute("persons", list);
        model.addAttribute("searchrequest", new SearchRequest());
        return "allperson";
    }

    //add
    @GetMapping("add")
    public ModelAndView add() {
        ModelAndView mav = new ModelAndView("add");
        mav.addObject("person", new Person());
        return mav;
    }

    //
    @PostMapping("add")
    public String add(@ModelAttribute("person") Person person) {
        personDao.add(person);
        return "redirect:/";
    }

    //edit

    @GetMapping("edit/{id}")
    public ModelAndView ModelAndView(@PathVariable("id") int id) {
        Optional<Person> personCreated = personDao.showById(id);
        ModelAndView mav = new ModelAndView("edit");
        mav.addObject("personCreated", personCreated);
        return mav;
    }

    //update
    @PostMapping("edit")
    public String update(@ModelAttribute("personCreated") Person person) {
        personDao.update(person);
        return "redirect:/";
    }


    //delete
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") int id) {
        personDao.deleteByID(id);
        return "redirect:/";
    }


}
