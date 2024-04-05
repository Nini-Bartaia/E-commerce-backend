package com.GroupProject.ecommerce.backend.controller;

import com.GroupProject.ecommerce.backend.model.Order;
import com.GroupProject.ecommerce.backend.modelBody.LoginBody;
import com.GroupProject.ecommerce.backend.modelBody.OrderCreationRequest;
import com.GroupProject.ecommerce.backend.modelBody.OrderResponse;
import com.GroupProject.ecommerce.backend.service.OrderService;
import com.GroupProject.ecommerce.backend.service.UserService;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private OrderService orderService;
    private UserService userService;


    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @PostMapping("order/create")
    public OrderResponse createOrder(@RequestBody OrderCreationRequest request) {

        if (this.userService.getType()) {


            throw new AccessDeniedException("Access denied: You are not an user");



        }else {
            Order order = this.orderService.createOrder(request.getUser(), request.getProductId());
            return new OrderResponse(order);
        }
    }

    @PostMapping("order/create-cart-products")
    public List<Order> createCartOrder(@RequestBody LoginBody loginBody) {


        if (this.userService.getType()) {


            throw new AccessDeniedException("Access denied: You are not an user");



        }else {
            return this.orderService.createOrderCart(loginBody);

        }
    }



}
