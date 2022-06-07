package com.example.springsample.service;

import com.example.springsample.entity.Product;
import com.example.springsample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product add(Product product) {
        product.setId(null);
        return productRepository.save(product);
    }

    public Product update(Product product) {
        Long id = product.getId();
        if (id != null) {
            Optional<Product> p = productRepository.findById(id);
            if (p.isPresent()) {
                return productRepository.save(product);
            }
        }
        return null;
    }

    public Product delete(Long id) {
        if (id != null) {
            Optional<Product> product = productRepository.findById(id);
            if (product.isPresent()) {
                productRepository.deleteById(id);
                return product.get();
            }
        }
        return null;
    }
}
