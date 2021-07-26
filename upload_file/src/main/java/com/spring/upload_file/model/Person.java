package com.spring.upload_file.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Person {
    @JsonIgnore
    private int id;
    @Size(min = 4, max = 30, message = "Name must between 5 and 30")
    private String name;
    @NotBlank(message = "gender cannot null")
    private String gender;
    @NotBlank(message = "birthday cannot null")
    private String birthday;
    @NotBlank(message = "job cannot null")
    private String job;

    private MultipartFile photo;

    private String linkimg;

    public Person() {

    }

    public Person(int id, String name, String gender, String birthday, String job, String linkimg) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.job = job;
        this.linkimg = linkimg;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    public String getLinkimg() {
        return linkimg;
    }

    public void setLinkimg(String linkimg) {
        this.linkimg = linkimg;
    }
}
