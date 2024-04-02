package com.GroupProject.ecommerce.backend.controller;

import com.GroupProject.ecommerce.backend.model.Order;
import com.GroupProject.ecommerce.backend.modelBody.LoginBody;
import com.GroupProject.ecommerce.backend.modelBody.OrderCreationRequest;
import com.GroupProject.ecommerce.backend.modelBody.OrderResponse;
import com.GroupProject.ecommerce.backend.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("order/create")
    public OrderResponse createOrder(@RequestBody OrderCreationRequest request) {
        Order order = this.orderService.createOrder(request.getUser(), request.getProductId());
        return new OrderResponse(order);
    }

    @PostMapping("order/create-cart-products")
    public List<Order> createCartOrder(@RequestBody LoginBody loginBody) {
        return this.orderService.createOrderCart(loginBody);
    }



}
