package com.GroupProject.ecommerce.backend.service;

import com.GroupProject.ecommerce.backend.model.Cart;
import com.GroupProject.ecommerce.backend.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CartService {


    List<Product> cartList= new ArrayList<>();


    private ProductService productService;

    public CartService(ProductService productService) {
        this.productService = productService;
    }


    public Cart addProduct(int productId, int quantity){
        Cart cart= new Cart();

        cart.setProduct(this.productService.getProduct(productId));
        cart.setNumOfpProducts(quantity);

        cartList.add(cart.getProduct());

        return cart;

    }

    public List<Product> getCart(){

        return cartList;
    }


}
