package com.example.heroku.repositories;

import com.example.heroku.entities.Ticket;
import com.example.heroku.entities.TicketConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketConfigRepository extends JpaRepository<TicketConfig,Long> {

    @Query("SELECT t FROM TicketConfig t JOIN Event e ON t.event = e.id WHERE e.id = :eventId")
    List<TicketConfig> findByEventid(@Param("eventId") long eventId);
}
