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
import java.util.Random;

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
        ticket.setSeat(randomSeat());
        ticket.setQrUrl("https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=www.glovoapp.com");
        ticket.setSeatZoneUrl("https://i.ibb.co/nc50Fb9/Screenshot-2019-05-03-at-05-08-29.png");
        return repository.save(ticket);
    }

    public List<Ticket> findByCustomerId(long customerId) {
        return repository.findByCustomerId(customerId);
    }


    private String randomSeat() {
        final Random random = new Random();
        final int intPart = random.nextInt(500);
        final String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final char letter = abc.charAt(random.nextInt(abc.length()));

       return String.format("%d%s",intPart,letter);
    }


}
