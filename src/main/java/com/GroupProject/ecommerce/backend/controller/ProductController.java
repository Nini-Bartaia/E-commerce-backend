package com.GroupProject.ecommerce.backend.controller;

import com.GroupProject.ecommerce.backend.model.Product;
import com.GroupProject.ecommerce.backend.service.ProductService;
import com.GroupProject.ecommerce.backend.service.UserService;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController


public class ProductController {

    private final AuthController authController;
    private final ProductService productService;

    private final UserService userService;

    public ProductController(AuthController authController, ProductService productService, UserService userService) {
        this.authController = authController;
        this.productService = productService;
        this.userService = userService;
    }


    @PostMapping("/products/create")
    public Product CreateProduct(Product product){

        if (this.userService.getType()) {


            this.productService.createProduct(product);

            return product;

        }else {

            throw new AccessDeniedException("Access denied: You are not an admin");
        }


    }

    @GetMapping("/products/get")
    public List<Product> CreateProduct(){

        if (this.userService.getType()) {


            return this.productService.getProducts();

        }else {

            throw new AccessDeniedException("Access denied: You are not an admin");
        }




    }

    @GetMapping("products/get-product/{productIndex}")
    public Product getProduct(@PathVariable("productIndex") int productIndex)
    {

        if (this.userService.getType()) {


            return productService.getProduct(productIndex);

        }else {

            throw new AccessDeniedException("Access denied: You are not an admin");
        }



    }

    @PutMapping("products/update-product/{productIndex}")
    public Product updateProduct(@PathVariable("productIndex") int productIndex, Product product)
    {
        if (this.userService.getType()) {


            return productService.updateProduct(productIndex, product);

        }else {

            throw new AccessDeniedException("Access denied: You are not an admin");
        }


    }
    @DeleteMapping("products/delete-product/{productIndex}")
    public void deleteProduct(@PathVariable("productIndex") int index){

        if (this.userService.getType()) {


            productService.deleteProduct(index);

        }else {

            throw new AccessDeniedException("Access denied: You are not an admin");
        }

    }


}



