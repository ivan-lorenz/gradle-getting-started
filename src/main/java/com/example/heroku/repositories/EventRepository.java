package com.example.heroku.repositories;

import com.example.heroku.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Long> {

    @Query("SELECT e FROM Event e JOIN Venue v ON e.venue = v.id WHERE v.cityCode = :cityCode")
    List<Event> findByCityCode(@Param("cityCode") String cityCode);
}
