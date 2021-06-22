package com.spring.helloworld.model;
public class Phim {
    
    private String title;
    private String director;
    private String description;
    private int year;
    public Phim(String title, String director, String description, int year) {
        this.title = title;
        this.director = director;
        this.description = description;
        this.year = year;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setDescription( String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
    public void setYear(int year){
        this.year = year;
    }
    public int getYear(){
        return year;
    }
    
}
