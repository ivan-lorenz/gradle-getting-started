package com.example.heroku.repositories;

import com.example.heroku.entities.Ticket;
import com.example.heroku.entities.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {}
