package com.example.heroku.dtos;

import com.example.heroku.entities.Event;

import java.util.List;

public class EventDTO {
    private final Event event;
    private final List<TicketConfigDTO> ticketConfigs;

    public EventDTO(Event event, List<TicketConfigDTO> ticketConfigs) {
        this.event = event;
        this.ticketConfigs = ticketConfigs;
    }

    public Event getEvent() {
        return event;
    }

    public List<TicketConfigDTO> getTicketConfigs() {
        return ticketConfigs;
    }
}
