package com.example.heroku.dtos;

import com.example.heroku.entities.Venue;

import java.util.List;

public class VenueDTO {
    private final long id;
    private final String name;
    private final String address;
    private final List<StoreDTO> stores;

    public VenueDTO(long id, String name, String address, List<StoreDTO> stores) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.stores = stores;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public static VenueDTO from(Venue venue, List<StoreDTO> stores) {
        return new VenueDTO(venue.getId(),venue.getName(), venue.getAddress(), stores);
    }
}
