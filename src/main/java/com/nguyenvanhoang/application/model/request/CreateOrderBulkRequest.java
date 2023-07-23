package com.nguyenvanhoang.application.model.request;

import java.util.List;

public class CreateOrderBulkRequest {
    private List<CreateOrderRequest> orders;

    public List<CreateOrderRequest> getOrders() {
        return orders;
    }

    public void setOrders(List<CreateOrderRequest> orders) {
        this.orders = orders;
    }
}