package com.example.heroku.repositories;

import com.example.heroku.entities.Ticket;
import com.example.heroku.entities.TicketType;
import com.example.heroku.entities.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

    @Query("SELECT count(t) FROM Ticket t WHERE t.event.id = :eventId AND t.type = :type")
    long countByEventIdAndTicketType(@Param("eventId") long eventId,@Param("type") TicketType type);

    @Query("SELECT t FROM Ticket t WHERE t.customer_id = :customerId")
    List<Ticket> findByCustomerId(@Param("customerId") long customerId);
}
