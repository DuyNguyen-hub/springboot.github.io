package com.spring.unittest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import com.spring.unittest.model.Person;
import com.spring.unittest.repository.CityJobCount;
import com.spring.unittest.repository.JobCount;
import com.spring.unittest.repository.PersonRepository;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@Sql({"/person.sql"})
public class PersonTest {
    @Autowired
    private PersonRepository personRepo;

    @Test
    public void countingByJob(){
        List<JobCount> jobCounts = personRepo.countByJob();
        jobCounts.forEach(System.out::println);
        assertThat(jobCounts.size()).isGreaterThan(4);
    }

    @Test
    public void fillAll(){
        List<Person> getAll = personRepo.findAll();
       getAll.forEach(System.out::println);
        assertThat(getAll.size()).isGreaterThan(4);
    }

    @Test
    public void findCountJobsInCity(){
        List<CityJobCount> cityJobCounts = personRepo.countJobsInCity();
       cityJobCounts.forEach(System.out::println);
        assertThat(cityJobCounts.size()).isGreaterThan(2);
    }
}
