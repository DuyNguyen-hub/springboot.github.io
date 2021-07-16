package com.spring.thymeleaf_form_ex06.repository;

import com.spring.thymeleaf_form_ex06.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PersonRepo implements PersonInterface {

    public PersonRepo() {
        collections.add(new Person(1, "Jons", "developer", "male", "1992-05-19"));
        collections.add(new Person(2, "Linh Nguyễn", "teacher", "female", "1990-11-26"));
        collections.add(new Person(3, "Ishikawa", "teacher", "male", "1992-01-25"));
        collections.add(new Person(4, "Yokochan", "doctor", "female", "1989-10-19"));
        collections.add(new Person(5, "Lampad", "banker", "male", "1986-11-22"));
        collections.add(new Person(6, "Hoàng Văn", "teacher", "male", "1995-01-29"));
        collections.add(new Person(7, "Mỹ Linh", "banker", "female", "1997-10-10"));
        collections.add(new Person(8, "Jame", "developer", "male", "1992-01-21"));
        collections.add(new Person(9, "SungApao", "teacher", "female", "1993-08-12"));
        collections.add(new Person(10, "Liltidy", "banker", "male", "1994-09-25"));

    }

    @Override
    public List getAll() {
        return collections;
    }

    @Override
    public void add(Person person) {
        int id;
        if (collections.isEmpty()) {
            id = 1;
        } else {
            Person lastPerson = (Person) collections.get(collections.size() - 1);
            id = lastPerson.getId() + 1;
        }
        person.setId(id);
        person.setName(person.getName());
        person.setJob(person.getJob());
        person.setGender(person.getGender());
        person.setBirthday(person.getBirthday());
        collections.add(person);
    }

    //showById
    @Override
    public Optional<Person> showById(int id) {
        return collections
                .stream()
                .filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public void update(Person person) {
        showById(person.getId()).ifPresent(personUpdate -> {
            personUpdate.setName(person.getName());
            personUpdate.setJob(person.getJob());
            personUpdate.setGender(person.getGender());
            personUpdate.setBirthday(person.getBirthday());

        });
    }

    //delete
    @Override
    public void deleteByID(int id) {
        showById(id).ifPresent(person -> collections.remove(person));

    }

    //search
    @Override
    public List<Person> searchByKeyword(String keyword) {
        return collections
                .stream()
                .filter(person -> person.matchWithKeyword(keyword))
                .collect(Collectors.toList());
    }
}
