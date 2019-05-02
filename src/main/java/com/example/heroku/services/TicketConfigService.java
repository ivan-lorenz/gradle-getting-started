package com.example.heroku.services;

import com.example.heroku.entities.Event;
import com.example.heroku.entities.TicketConfig;
import com.example.heroku.repositories.EventRepository;
import com.example.heroku.repositories.TicketConfigRepository;
import com.example.heroku.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketConfigService {

    @Autowired
    private TicketConfigRepository repository;

    public List<TicketConfig> findByEventId(long eventId) {
        return repository.findByEventid(eventId);
    }

    public TicketConfig findById(long ticketConfigId) {
        return repository.findById(ticketConfigId).orElse(null);
    }
}
