


package vn.techmaster.basicthymeleaf.thymeleaf_ex5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.techmaster.basicthymeleaf.thymeleaf_ex5.model.Person;
import vn.techmaster.basicthymeleaf.thymeleaf_ex5.repository.MemoryRepository;

import java.util.List;

@Controller
@RequestMapping("")
public class HomeController {
    @Autowired
    private MemoryRepository memoryRepository;

    @GetMapping("")
    public String about(){
        return "main-layout";
    }

    //
    @GetMapping("show")
    public ModelAndView  peopleshow(){
        List<Person> peoples = memoryRepository.getPersons();
        ModelAndView mav = new ModelAndView("peopleshow");
        mav.addObject("peoples", peoples);
        return mav;
    }

    //
    @GetMapping("showBy2Colums")
    public ModelAndView showBy2Colums(){

        List<Person> peoples = memoryRepository.getPersons();
        ModelAndView mav = new ModelAndView("showby2colums");
        mav.addObject("peoples", peoples);
        return mav;
    }


}
