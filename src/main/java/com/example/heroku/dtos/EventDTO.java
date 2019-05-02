package com.example.heroku.dtos;

import com.example.heroku.entities.Category;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class EventDTO {

    private final long id;
    private final String name;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private final Date start;
    private final Category category;
    private final VenueDTO venue;
    private final List<TicketConfigDTO> ticketConfig;

    public EventDTO(long id, String name, Date start, Category category, VenueDTO venue, List<TicketConfigDTO> ticketConfig) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.category = category;
        this.venue = venue;
        this.ticketConfig = ticketConfig;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getStart() {
        return start;
    }

    public Category getCategory() {
        return category;
    }

    public VenueDTO getVenue() {
        return venue;
    }

    public List<TicketConfigDTO> getTicketConfig() {
        return ticketConfig;
    }
}
