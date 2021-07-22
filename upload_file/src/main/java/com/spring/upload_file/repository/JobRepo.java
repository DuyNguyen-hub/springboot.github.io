package com.spring.upload_file.repository;

import com.spring.upload_file.model.Job;
import com.spring.upload_file.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JobRepo implements JobInterface{

    public JobRepo(){
        collections.add(new Job(1, "developer"));
        collections.add(new Job(2, "teacher"));
    }

    @Override
    public List<Job> getAll() {
        return collections;
    }

    @Override
    public void add(Job job) {
        int id;
        if (collections.isEmpty()) {
            id = 1;
        } else {
            Job lastJob = (Job) collections.get(collections.size() - 1);
            id = lastJob.getId() + 1;
        }

        job.setId(id);
        job.setName(job.getName());

        collections.add(job);
    }

    @Override
    public Optional<Job> showById(int id) {
        return collections.stream()
                .filter(p->p.getId() == id).findFirst();
    }

    //update
    @Override
    public void update(Job job) {
        //update
        showById(job.getId()).ifPresent(jobUpdate -> {
           jobUpdate.setName(job.getName());
        });
    }
    //delete
    @Override
    public void deleteByID(int id) {
        //xoá object
        collections.removeIf(item -> item.getId() == id);
    }
    @Override
    public List<Person> searchByKeyword(String keyword) {
        return null;
    }
}
