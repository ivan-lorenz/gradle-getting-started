package com.example.heroku.dtos;

public class CustomerTicketDTO {
    private final long id;
    private final EventDTO event;
    private final String seat;
    private final String qrUrl;

    public CustomerTicketDTO(long id, EventDTO event, String seat, String qrUrl) {
        this.id = id;
        this.event = event;
        this.seat = seat;
        this.qrUrl = qrUrl;
    }

    public long getId() {
        return id;
    }

    public EventDTO getEvent() {
        return event;
    }

    public String getSeat() {
        return seat;
    }

    public String getQrUrl() {
        return qrUrl;
    }
}
