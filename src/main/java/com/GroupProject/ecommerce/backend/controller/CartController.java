package com.GroupProject.ecommerce.backend.controller;

import com.GroupProject.ecommerce.backend.model.Cart;
import com.GroupProject.ecommerce.backend.model.Product;
import com.GroupProject.ecommerce.backend.modelBody.LoginResponse;
import com.GroupProject.ecommerce.backend.service.CartService;
import com.GroupProject.ecommerce.backend.service.UserService;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Objects;

@RestController
public class CartController {

    private CartService cartService;

    private UserService userService;


    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    @PostMapping("cart/add-product")
    public Cart addProduct(@RequestParam int productId, @RequestParam int quantity){

        if (this.userService.getType()) {


            throw new AccessDeniedException("Access denied: You are not an user");



        }else {

            Cart cart = this.cartService.addProduct(productId, quantity);

            return cart;
        }

    }


    @PostMapping("cart/get-cart")

        public List<Product> getCart(){

        if (this.userService.getType()) {


            throw new AccessDeniedException("Access denied: You are not an user");



        }else {

            return this.cartService.getCart();
        }


        }



}
