package com.example.film.models;

import java.util.List;

public class Categories {
    String categories;
    List<Film> filmList;
    Categories(){}
    public List<Film> getFilmList() {
        return filmList;
    }

    public String getCategories() {
        return categories;
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }
}
