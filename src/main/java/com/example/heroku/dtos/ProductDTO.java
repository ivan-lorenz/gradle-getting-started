package com.example.heroku.dtos;

public class ProductDTO {
    private long id;
    private String name;
    private double price;
    private String urlImage;

    public ProductDTO(long id, String name, double price, String urlImage) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.urlImage = urlImage;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getUrlImage() {
        return urlImage;
    }
}
