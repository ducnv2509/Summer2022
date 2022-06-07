package com.example.lab04.service;

import com.example.lab04.CartItem;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private Map<Integer, CartItem> map = new HashMap<>();

    public void add(CartItem item) {
        CartItem existedItem = map.get(item.getId());
        if (existedItem != null) {
            existedItem.setQuantity(item.getQuantity() + existedItem.getQuantity());
        } else {
            map.put(item.getId(), item);
        }
    }

    public void remove(int id) {
        map.remove(id);
    }

    public Collection<CartItem> getCarItems() {
        return map.values();
    }

    public void clear() {
        map.clear();
    }

    public void update(int id, int quantity) {
        CartItem item = map.get(id);
        item.setQuantity(quantity);
        if (item.getQuantity() <= 0) {
            map.remove(id);
        }
    }

    public double getAmount() {
        return map.values().stream().mapToDouble(item -> item.getQuantity() * item.getPrice()).sum();
    }

    public int getCount() {
        if (map.isEmpty()) {
            return 0;
        }
        return map.values().size();
    }
}
