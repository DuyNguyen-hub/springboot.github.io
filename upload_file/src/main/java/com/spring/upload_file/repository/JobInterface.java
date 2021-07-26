package com.spring.upload_file.repository;

import com.spring.upload_file.model.Job;
import com.spring.upload_file.model.Person;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface JobInterface {
    List<Job> collections = new ArrayList<>();

    public List<Job> getAll();

    public void add(Job job);

    public Optional<Job> showById(int id);

    public Optional<Job> showByName(String name);

    public void update(Job job);

    public void deleteByID(int id);

    public List<Person> searchByKeyword(String keyword);
}
