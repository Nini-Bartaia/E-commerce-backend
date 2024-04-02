package com.GroupProject.ecommerce.backend.model;

import com.GroupProject.ecommerce.backend.service.ProductService;
import com.GroupProject.ecommerce.backend.service.UserService;

public class Order {

    private User user;
    private String status;

    private Product product;


    private ProductService productService;
    private UserService userService;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {


        this.user= user;
    }

    public void setProduct(Product product){

       this.product= product;

    }
    public Product getProduct(){

        return product;
    }


}
