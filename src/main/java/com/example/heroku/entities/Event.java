package com.example.heroku.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    private String urlImage;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", start=" + start +
                ", category=" + category +
                ", venue=" + venue +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
