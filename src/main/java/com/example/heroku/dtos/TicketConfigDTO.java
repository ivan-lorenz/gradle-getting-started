package com.example.heroku.dtos;

import com.example.heroku.entities.TicketType;

public class TicketConfigDTO {

    private final long id;
    private final TicketType type;
    private final String price;
    private final long remaining;

    public TicketConfigDTO(long id, TicketType type, String price, long remaining) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.remaining = remaining;
    }

    public long getId() {
        return id;
    }

    public TicketType getType() {
        return type;
    }

    public String getPrice() {
        return price;
    }

    public long getRemaining() {
        return remaining;
    }

}
