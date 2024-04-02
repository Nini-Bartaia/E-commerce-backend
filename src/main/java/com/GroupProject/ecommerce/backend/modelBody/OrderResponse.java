package com.GroupProject.ecommerce.backend.modelBody;

import com.GroupProject.ecommerce.backend.model.Order;


public class OrderResponse {

    private Order order;

    public OrderResponse(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
