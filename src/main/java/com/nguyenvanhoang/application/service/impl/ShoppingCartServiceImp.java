package com.nguyenvanhoang.application.service.impl;

import java.util.Collection;
import java.util.Map;

import com.nguyenvanhoang.application.entity.CartItem;
import com.nguyenvanhoang.application.service.ShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;

@SessionScope
@Service
public class ShoppingCartServiceImp implements ShoppingCartService {
    Map<String, CartItem> maps = new HashMap<>(); //Gio hang


    public void add(CartItem item) {
        String key = item.getProductId() + item.getSize();
        CartItem cartItem = maps.get(key);
        if (cartItem == null) {
            // If the product is not already in the cart, add it with the given item size
            maps.put(key, item);
        } else {
            // If the product is already in the cart with the same size, increase its quantity by 1
            cartItem.setQty(cartItem.getQty() + 1);
        }
    }

    public void remove(String id, int size) {
        String key = id + size;
        maps.remove(key);
    }

    public void clear(){
        maps.clear();
    }

    public Collection<CartItem> getAllItems (){
        return maps.values();
    }

    public int getCount(){
        return maps.values().size();
    }

    public double getAmount(){
        return maps.values().stream()
                .mapToDouble(item -> item.getQty() * item.getPrice())
                .sum();
    }
}
