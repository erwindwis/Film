package com.example.film.models;

public class Film {
    String title, description, imageUrl, rating, uid;
    public Film(String title, String description,String imageUrl, String rating){
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.imageUrl = imageUrl;
    }
    Film(){}
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

}
