package com.example.heroku.entities;

import javax.persistence.*;

@Entity
public class TicketConfig {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private TicketType type;
    private double price;
    private long quantity;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;


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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "TicketConfig{" +
                "id=" + id +
                ", type=" + type +
                ", price=" + price +
                ", quantity=" + quantity +
                ", event=" + event +
                '}';
    }
}
