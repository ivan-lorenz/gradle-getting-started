package com.example.heroku.dtos;

import java.util.List;

public class StoreDTO {
    private long id;
    private String name;
    private String zone;
    private String urlImage;
    private List<ProductDTO> products;

    public StoreDTO(long id, String name, String zone, String urlImage, List<ProductDTO> products) {
        this.id = id;
        this.name = name;
        this.zone = zone;
        this.urlImage = urlImage;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getZone() {
        return zone;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public String getUrlImage() {
        return urlImage;
    }
}
