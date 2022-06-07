package com.example.crud_sp.controller;

import com.example.crud_sp.entity.Product;
import com.example.crud_sp.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    IProductRepository productRepository;

    @RequestMapping("/getList")
    public List<Product> getAProducts() {
        return productRepository.findAll();
    }

    @RequestMapping("/add")
    public Product add() {
        Product p = new Product();
        p.setProductName("OK1");
        p.setQuantity(1000);
        p.setPrice(BigDecimal.valueOf(1000));
        return productRepository.save(p);
    }

    @RequestMapping("/update")
    public Product update() {
        Product p = new Product();
        p.setProductName("OKUpdate");
        p.setProductId(1);
        p.setQuantity(5);
        p.setPrice(BigDecimal.valueOf(1000));
        return productRepository.save(p);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        productRepository.deleteById(id);
    }
}
