package com.example.heroku.repositories;

import com.example.heroku.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {}
