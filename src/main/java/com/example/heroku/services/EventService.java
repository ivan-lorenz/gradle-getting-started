package com.example.heroku.services;

import com.example.heroku.entities.Event;
import com.example.heroku.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> findByCityCode(String cityCode) {
        return eventRepository.findByCityCode(cityCode);
    }

    public Event findById(long eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }
}
