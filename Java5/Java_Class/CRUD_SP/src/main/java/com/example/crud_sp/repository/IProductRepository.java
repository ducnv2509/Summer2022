package com.example.crud_sp.repository;

import com.example.crud_sp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByProductNameLike(String id);
}
