package com.spring.upload_file.repository;

import com.spring.upload_file.model.Person;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface PersonInterface {
    List<Person> collections = new ArrayList<>();

    public List<Person> getAll();

    public void add(Person person, BindingResult result);

    public Optional<Person> showById(int id);

    public void update(Person person);

    public void deleteByID(int id);

    public List<Person> searchByKeyword(String keyword);
}
