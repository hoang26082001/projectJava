package com.nguyenvanhoang.application.service;

import com.nguyenvanhoang.application.entity.CartItem;

import java.util.Collection;

public interface ShoppingCartService {
    double getAmount();
    int getCount();
    Collection<CartItem> getAllItems();
    void clear();
    void remove (String id, int size);
    void add(CartItem item);
}
