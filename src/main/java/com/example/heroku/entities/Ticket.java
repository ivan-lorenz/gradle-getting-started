package com.example.heroku.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Enumerated(EnumType.STRING)
    private TicketType type;
    private long customer_id;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private String seat;
    private String qrUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getQrUrl() {
        return qrUrl;
    }

    public void setQrUrl(String qrUrl) {
        this.qrUrl = qrUrl;
    }
}
