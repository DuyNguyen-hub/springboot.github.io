package com.spring.upload_file.controller;

import com.spring.upload_file.exception.StorageException;
import com.spring.upload_file.model.Person;
import com.spring.upload_file.repository.PersonInterface;
import com.spring.upload_file.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("person")
@Slf4j
public class PersonController {

    @Autowired
    private PersonInterface personInterface;

    //show list person
    @GetMapping("main")
    public String getAll(Model model) {
//        log.info(searchRequest.getKeyword());
        List<Person> list = personInterface.getAll();

        model.addAttribute("persons", list);
        return "people/list";
    }

    //add
    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute("person", new Person());
        return "people/add";
    }

    @PostMapping(value = "/add", consumes = {"multipart/form-data"})
    public String upload(@Valid @ModelAttribute Person person, BindingResult result, Model model) {
        // xử lí các trường để trống thi báo lỗi
        if (person.getPhoto().getOriginalFilename().isEmpty()) {
            result.addError(new FieldError("person", "photo", "Photo is required"));
        } else if (person.getName().isEmpty()) {
            result.addError(new FieldError("person", "name", "name field cannot be left blank"));
        } else if (person.getGender().isEmpty()) {
            result.addError(new FieldError("person", "gender", "please choose gender"));
        } else if (person.getBirthday().isEmpty()) {
            result.addError(new FieldError("person", "birthday", "please choose bỉthday"));
        }
        if (result.hasErrors()) {
            return "people/add";
        }
        personInterface.add(person, result);
        return "redirect:/person/main";
    }

    @ExceptionHandler(StorageException.class)
    public String handleStorageFileNotFound(StorageException e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "failure";
    }

    //edit
    @GetMapping("edit/{id}")
    public String showById(@PathVariable("id") int id, Model model) {
        Optional<Person> personCreated = personInterface.showById(id);
        model.addAttribute("person", personCreated);
        model.addAttribute("idPerson", id);
        return "people/edit";

    }

    @PostMapping(value = "edit", consumes = {"multipart/form-data"})
    public String update(@Valid @ModelAttribute Person person, BindingResult result, Model model) {
        // xử lí các trường để trống thì báo lỗi ra
        if (person.getPhoto().getOriginalFilename().isEmpty()) {
            result.addError(new FieldError("person", "photo", "Photo is required"));
        } else if (person.getName().isEmpty()) {
            result.addError(new FieldError("person", "name", "name field cannot be left blank"));
        } else if (person.getGender().isEmpty()) {
            result.addError(new FieldError("person", "gender", "please choose gender"));
        } else if (person.getBirthday().isEmpty()) {
            result.addError(new FieldError("person", "birthday", "please choose bỉthday"));
        }
        if (result.hasErrors()) {
            return "people/add";
        }
        personInterface.update(person);
        return "redirect:/person/main";
    }

    //delete
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") int id) {
        personInterface.deleteByID(id);
        return "redirect:/person/main";
    }
}
