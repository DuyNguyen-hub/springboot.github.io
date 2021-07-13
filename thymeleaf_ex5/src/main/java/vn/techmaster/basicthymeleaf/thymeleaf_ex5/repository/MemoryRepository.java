package vn.techmaster.basicthymeleaf.thymeleaf_ex5.repository;

import org.springframework.stereotype.Repository;

import vn.techmaster.basicthymeleaf.thymeleaf_ex5.model.Person;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryRepository {
    private ArrayList<Person> persons;


    public MemoryRepository(){
        //persons
        persons = new ArrayList<>(List.of(
                new Person("Duy Nguyen", "Viet Nam", "05-06-1995", "male"),
                new Person("Jons David", "Usa", "02-08-1990", "male"),
                new Person("Yokochan", "Japan", "10-06-2000", "female"),
                new Person("Anna", "Rusia", "20-06-1999", "female"),
                new Person("Ziang", "China", "23-06-1996", "female"),
                new Person("pukathek", "Thailand", "19-03-1993", "male"),
                new Person("Jons David", "Usa", "02-08-1990", "male"),
                new Person("Yokochan", "Japan", "10-06-2000", "female"),
                new Person("Anna", "Rusia", "20-06-1999", "female"),
                new Person("Ziang", "China", "23-06-1996", "female")
        ));


    }

    //
    public List<Person> getPersons(){
        return  persons;
    }
}
