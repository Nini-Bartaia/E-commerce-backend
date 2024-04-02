package com.GroupProject.ecommerce.backend.service;


import com.GroupProject.ecommerce.backend.model.Order;
import com.GroupProject.ecommerce.backend.model.Product;
import com.GroupProject.ecommerce.backend.modelBody.LoginBody;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    List<Order> orders = new ArrayList<>();
    private UserService userService;

    private ProductService productService;

    private CartService cartService;


    public OrderService(UserService userService, ProductService productService, CartService cartService) {
        this.userService = userService;
        this.productService = productService;
        this.cartService = cartService;
    }

    public Order createOrder(LoginBody user, int ProductId){

            Order order= new Order();
            order.setUser(this.userService.login(user));
            order.setProduct(this.productService.getProduct(ProductId));


           double budget= order.getUser().getBudget();

           if(order.getUser().getBudget() > order.getProduct().getPrice() && order.getProduct().getStockQuantity()>0){

               order.setStatus("Accepted");
               budget=order.getUser().getBudget()-order.getProduct().getPrice();
               this.userService.login(user).setBudget(budget);
           }else{
               order.setStatus("Failed");
           }

            return order;


    }
    public List<Order> createOrderCart(LoginBody user) {

        for (int i = 0; i < this.cartService.cartList.size(); i++) {
            Product product = this.cartService.cartList.get(i);


            Order order = new Order();
            order.setUser(this.userService.login(user));
            order.setProduct(product);

            double budget = order.getUser().getBudget();

            if (budget > product.getPrice() && product.getStockQuantity() > 0) {
                order.setStatus("Accepted");
                budget -= product.getPrice();
                order.getUser().setBudget(budget);
                product.setStockQuantity(product.getStockQuantity() - 1); // Decrease stock quantity
            } else {
                order.setStatus("Failed");
            }

            orders.add(order);
        }

        return orders;
    }


}