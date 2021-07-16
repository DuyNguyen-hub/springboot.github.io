package thymeleaf.thymeleaf_form.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import thymeleaf.thymeleaf_form.model.Person;

@Repository
public class PersonDao extends Dao<Person>{
    public PersonDao(){
        collections.add(new Person(1, "Jons", "developer", "male", "21-01-1992"));
        collections.add(new Person(2, "Alex", "teacher", "male", "10-01-1990"));
    }
    @Override
    public List<Person> getAll() {
        return collections;
    }

    @Override
    public Optional<Person> get(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void add(Person t) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(Person t) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteByID(int id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Person t) {
        // TODO Auto-generated method stub
        
    }
    
}
