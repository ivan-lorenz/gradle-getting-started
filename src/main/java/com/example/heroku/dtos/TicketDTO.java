package com.example.heroku.dtos;

import com.example.heroku.entities.Venue;

public class TicketDTO {
    private final long ticketId;
    private final String countryCode;
    private final String currency;
    private final double price;


    public TicketDTO(long ticketId, String countryCode, String currency, double price) {
        this.ticketId = ticketId;
        this.countryCode = countryCode;
        this.currency = currency;
        this.price = price;
    }

    public long getTicketId() {
        return ticketId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCurrency() {
        return currency;
    }

    public double getPrice() {
        return price;
    }
}
