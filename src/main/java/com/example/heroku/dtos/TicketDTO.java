package com.example.heroku.dtos;

import com.example.heroku.entities.Venue;

public class TicketDTO {
    private final long ticketId;
    private final String countryCode;
    private final String currencyCode;
    private final double price;


    public TicketDTO(long ticketId, String countryCode, String currencyCode, double price) {
        this.ticketId = ticketId;
        this.countryCode = countryCode;
        this.currencyCode = currencyCode;
        this.price = price;
    }

    public long getTicketId() {
        return ticketId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCurrency() {
        return currencyCode;
    }

    public double getPrice() {
        return price;
    }
}
