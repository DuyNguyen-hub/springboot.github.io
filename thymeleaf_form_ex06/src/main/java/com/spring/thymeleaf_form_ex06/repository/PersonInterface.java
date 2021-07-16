package com.spring.thymeleaf_form_ex06.repository;

import com.spring.thymeleaf_form_ex06.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface PersonInterface {
    List<Person> collections = new ArrayList<>();

    public List getAll();

    public void add(Person person);

    public Optional<Person> showById(int id);

    public void update(Person person);

    public void deleteByID(int id);

    public List<Person> searchByKeyword(String keyword);
}
