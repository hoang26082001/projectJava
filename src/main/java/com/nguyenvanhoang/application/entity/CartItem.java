package com.nguyenvanhoang.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    private String productId;
    private String name;
    private long price;
    private int size;
    private int qty = 1;
    private String image;
}
