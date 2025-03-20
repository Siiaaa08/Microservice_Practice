package com.example.movie_catalog_service.model;

public class CatalogItem {
    private String name;
    private String desc;

    public CatalogItem(String name, String desc, double rating) {
        this.name = name;
        this.desc = desc;
        this.rating = rating;
    }

    private double rating;

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
