package com.spring.thymeleaf_form_ex06.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class Person {
    @JsonIgnore
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

    public Person() {

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public boolean matchWithKeyword(String keyword) {
        String keywordLowerCase = keyword.toLowerCase();
        return (name.toLowerCase().contains(keywordLowerCase) ||
                job.toLowerCase().contains(keywordLowerCase));
    }
}
