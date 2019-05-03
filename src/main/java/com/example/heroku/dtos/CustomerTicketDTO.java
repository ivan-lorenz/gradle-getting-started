package com.example.heroku.dtos;

public class CustomerTicketDTO {
    private final long id;
    private final EventDTO event;
    private final String seat;
    private final String qrUrl;
    private final String seatZoneUrl;

    public CustomerTicketDTO(long id, EventDTO event, String seat, String qrUrl, String seatZoneUrl) {
        this.id = id;
        this.event = event;
        this.seat = seat;
        this.qrUrl = qrUrl;
        this.seatZoneUrl = seatZoneUrl;
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

    public String getSeatZoneUrl() {
        return seatZoneUrl;
    }
}
