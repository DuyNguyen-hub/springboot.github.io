package com.spring.upload_file.controller;

import com.spring.upload_file.model.Job;
import com.spring.upload_file.model.Person;
import com.spring.upload_file.repository.JobInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("job")
public class JobController {
    @Autowired
    private JobInterface jobInterface;

    @GetMapping("")
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView("job/list");
        mav.addObject("jobs", jobInterface.getAll());
        mav.addObject("job", new Job());
        return mav;
    }

    @PostMapping("add")
    public String add(@Valid @ModelAttribute Job job, BindingResult result, Model model){
            jobInterface.add(job);
            return "redirect:/job";
    }

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("job", jobInterface.showById(id));
        model.addAttribute("jobId", id);
        return "job/edit";
    }
    @PostMapping(value = "edit")
    public String update(@Valid @ModelAttribute Job job) {
        jobInterface.update(job);
        return "redirect:/job";
    }

    //delete
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") int id) {
        jobInterface.deleteByID(id);
        return "redirect:/job";
    }

}
