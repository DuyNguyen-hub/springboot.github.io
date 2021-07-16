package thymeleaf.thymeleaf_form.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Person {
    private int id;
    private String name;
    private String job;
    private String gender;
    private String birthday;
    
    public Person(int id, String name, String job, String gender, String birthday) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.gender = gender;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String isGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthDay(String birthday) {
        this.birthday = birthday;
    }

    
}
