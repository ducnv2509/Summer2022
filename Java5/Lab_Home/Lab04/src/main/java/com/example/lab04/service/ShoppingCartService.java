package com.example.lab04.service;

import com.example.lab04.CartItem;

import java.util.Collection;

public interface ShoppingCartService {
    int getCount();
    double getAmount();
    void update(int id, int quantity);
    void clear();
    Collection<CartItem> getCarItems();
    void remove(int id);
    void add(CartItem item);
}
