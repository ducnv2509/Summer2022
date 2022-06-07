package com.example.lab04.service;

import com.example.lab04.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private static List<Product> list = new ArrayList<>();

    static {
        list.add(new Product(1, "Hat", 20, 2000));
        list.add(new Product(2, "Shoes", 30, 5000));
        list.add(new Product(3, "Jean", 42, 6000));
        list.add(new Product(4, "T-shirts", 40, 7000));
        list.add(new Product(5, "Skirt", 210, 7000));
    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < list.size(); i++) {
            Product item = list.get(i);
            if (item.getId() == product.getId()) {
                list.set(i, product);
                break;
            }
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    public Product findById(int id) {
        Optional<Product> optional = list.stream().filter(item -> item.getId() == id).findFirst();
        return optional.orElse(null);
    }

    @Override
    public void remove(int id) {
        list.removeIf(item -> item.getId() == id);

    }

    @Override
    public void add(Product product) {
        list.add(product);

    }
}
