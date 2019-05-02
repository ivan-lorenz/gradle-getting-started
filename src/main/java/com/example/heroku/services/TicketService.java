package com.example.heroku.services;

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

    public long countByTicketConfig(long eventId, TicketType type) {
        return repository.countByEventIdAndTicketType(eventId, type);
    }
}
