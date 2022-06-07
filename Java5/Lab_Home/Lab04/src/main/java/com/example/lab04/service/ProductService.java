package com.example.lab04.service;

import com.example.lab04.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    void update(Product product);
    List<Product> findAll();
    void remove(int id);
    void add(Product product);
    Product findById(int id);
}
