package com.example.heroku.dtos;

import java.util.List;

public class EventsDTO {

    private final List<EventDTO> events;

    public EventsDTO(List<EventDTO> events) {
        this.events = events;
    }

    public List<EventDTO> getEvents() {
        return events;
    }
}
