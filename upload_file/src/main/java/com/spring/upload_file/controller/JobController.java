package com.spring.upload_file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("job")
public class JobController {
    @GetMapping("")
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView("job/list");
        return mav;
    }
}
