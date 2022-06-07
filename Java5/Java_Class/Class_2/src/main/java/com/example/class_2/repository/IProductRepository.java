package com.example.class_2.repository;

import com.example.class_2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {

}
