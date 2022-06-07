package com.example.lab34.repository;

import com.example.lab34.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProductRepository extends JpaRepository<Product, Integer> {

}
