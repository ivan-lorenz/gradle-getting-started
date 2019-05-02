package com.example.heroku.repositories;

import com.example.heroku.entities.Event;
import com.example.heroku.entities.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue,Long> {}
