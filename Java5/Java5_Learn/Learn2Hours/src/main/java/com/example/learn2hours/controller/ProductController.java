package com.example.learn2hours.controller;

import com.example.learn2hours.Model.Product;
import com.example.learn2hours.Model.ResponseObject;
import com.example.learn2hours.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Products")
public class ProductController {
    // khởi tạo khi chạy dự án
    @Autowired
    private ProductRepository repository;

    @GetMapping("")
    List<Product> getAllProducts() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
//    Optional: cos the tra null
    ResponseEntity<ResponseObject> finById(@PathVariable Long id) {
        Optional<Product> foundProduct = repository.findById(id);
        return foundProduct.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Query product successfully", foundProduct)
        ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("False", "Cannot find with id = " + id, "")
                );

    }

    // insert new prod with POST
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product product) {
        // 2 product must not have the same name !
        List<Product> foundProducts = repository.findByProductName(product.getProductName().trim());
        if (foundProducts.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Product name same taken", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "insert product successfully", repository.save(product))
        );
    }

    // update, upsert = update if found, otherwise insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct, @PathVariable Long id) {
        Product updateProduct = repository.findById(id).map(
                product -> {
                    product.setProductName(newProduct.getProductName());
                    product.setYear(newProduct.getYear());
                    product.setPrice(newProduct.getPrice());
                    product.setUrl(newProduct.getUrl());
                    return repository.save(product);
                }
        ).orElseGet(() -> {
            newProduct.setId(id);
            return repository.save(newProduct);
        });

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "update product successfully", updateProduct)
        );
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long id){
        boolean exits =repository.existsById(id);
        if(exits){
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Delete product successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Delete error", "")
        );
    }
}
