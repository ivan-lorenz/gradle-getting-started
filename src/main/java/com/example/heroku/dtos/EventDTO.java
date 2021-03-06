package com.example.heroku.dtos;

import com.example.heroku.entities.Category;
import com.example.heroku.entities.Event;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.List;

public class EventDTO {

    private final long id;
    private final String name;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private final Date start;
    private final Category category;
    private final VenueDTO venue;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<TicketConfigDTO> ticketConfig;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String urlImage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String description;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<StoreDTO> stores;


    public EventDTO(long id, String name, Date start, Category category, VenueDTO venue, List<TicketConfigDTO> ticketConfig, String urlImage, String description, List<StoreDTO> stores) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.category = category;
        this.venue = venue;
        this.ticketConfig = ticketConfig;
        this.urlImage = urlImage;
        this.description = description;
        this.stores = stores;
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

    public String getUrlImage() {
        return urlImage;
    }

    public String getDescription() {
        return description;
    }

    public List<StoreDTO> getStores() {
        return stores;
    }

    public static EventDTO from(Event event, List<StoreDTO> stores) {
        return new EventDTO(event.getId(),
                event.getName(), event.getStart(), event.getCategory(), VenueDTO.from(event.getVenue(), null),null, event.getUrlImage(),null, stores);
    }
}
