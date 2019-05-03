package com.example.heroku.repositories;

import com.example.heroku.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product p WHERE p.store.id = :storeId")
    List<Product> findByStoreId(@Param("storeId") long storeId);
}
