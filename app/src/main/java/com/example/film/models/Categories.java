package com.example.film.models;

import java.util.List;

public class Categories {
    String categories;
    List<String> films;
    public Categories(){}

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }
}
