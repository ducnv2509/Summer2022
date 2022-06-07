package com.example.class_2.controller;

import com.example.class_2.entity.Product;
import com.example.class_2.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    IProductRepository productRepository;

    @RequestMapping("/getALL")
    public List<Product> getAProducts() {
        return productRepository.findAll();
    }

    @RequestMapping("/add")
    public Product add() {
        Product p = new Product();
        p.setName("OK1");
        p.setCreatedDate(new Date());
        p.setPrice(BigDecimal.valueOf(1000));
        return productRepository.save(p);
    }

    @RequestMapping("/update")
    public Product update() {
        Product p = new Product();
        p.setName("OKUpdate");
        p.setId(1);
        p.setCreatedDate(new Date());
        p.setPrice(BigDecimal.valueOf(1000));
        return productRepository.save(p);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        productRepository.deleteById(id);
    }

}
