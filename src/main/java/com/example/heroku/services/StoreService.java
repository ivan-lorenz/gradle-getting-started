package com.example.heroku.services;

import com.example.heroku.entities.Store;
import com.example.heroku.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public List<Store> findByVenueId(long findByVenueId) {
        return storeRepository.findByVenueId(findByVenueId);
    }

}
