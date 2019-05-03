package com.example.heroku.services;

import com.example.heroku.entities.Product;
import com.example.heroku.entities.Store;
import com.example.heroku.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findByStoreId(long storeId) {
        return productRepository.findByStoreId(storeId);
    }

}
