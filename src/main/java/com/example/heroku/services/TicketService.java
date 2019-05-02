package com.example.heroku.services;

import com.example.heroku.entities.Event;
import com.example.heroku.entities.Ticket;
import com.example.heroku.entities.TicketConfig;
import com.example.heroku.entities.TicketType;
import com.example.heroku.repositories.TicketConfigRepository;
import com.example.heroku.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repository;

    @Autowired
    private EventService eventService;


    @Autowired
    private TicketConfigService ticketConfigService;



    public long countByTicketConfig(long eventId, TicketType type) {
        return repository.countByEventIdAndTicketType(eventId, type);
    }

    public Ticket createTicket(long customerId, long eventId, long ticketTypeId) {
        Event event = eventService.findById(eventId);
        TicketType ticketType = ticketConfigService.findById(ticketTypeId).getType();

        Ticket ticket = new Ticket();
        ticket.setCustomer_id(customerId);
        ticket.setEvent(event);
        ticket.setType(ticketType);

        return repository.save(ticket);
    }
}
