package com.GroupProject.ecommerce.backend.controller;

import com.GroupProject.ecommerce.backend.model.Cart;
import com.GroupProject.ecommerce.backend.model.Product;
import com.GroupProject.ecommerce.backend.service.CartService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CartController {

    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("cart/add-product")
    public Cart addProduct(@RequestParam int productId, @RequestParam int quantity){

        Cart cart=this.cartService.addProduct(productId,quantity);
        return cart;

    }


    @PostMapping("cart/get-cart")

        public List<Product> getCart(){

            return this.cartService.getCart();
        }



}
