package com.saikalyandaroju.expressotestingdemo.model;

import java.util.ArrayList;

public class Movie {
    private int id;
    private String title, image, description;
    private ArrayList<String> directors;
    private ArrayList<String> star_actors;

    public Movie(int id, String title, String image, String description, ArrayList<String> directors, ArrayList<String> star_actors) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
        this.directors = directors;
        this.star_actors = star_actors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getDirectors() {
        return directors;
    }

    public void setDirectors(ArrayList<String> directors) {
        this.directors = directors;
    }

    public ArrayList<String> getStar_actors() {
        return star_actors;
    }

    public void setStar_actors(ArrayList<String> star_actors) {
        this.star_actors = star_actors;
    }
}
