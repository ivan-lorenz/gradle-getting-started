package com.example.heroku.repositories;

import com.example.heroku.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store,Long> {

    @Query("SELECT s FROM Store s WHERE s.venue.id=:venueId")
    List<Store> findByVenueId(@Param("venueId") long venueId);
}
