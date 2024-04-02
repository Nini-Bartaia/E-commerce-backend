package com.GroupProject.ecommerce.backend.controller;

import com.GroupProject.ecommerce.backend.model.Product;
import com.GroupProject.ecommerce.backend.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController


public class ProductController {

    private final AuthController authController;
    private final ProductService productService;

    public ProductController(AuthController authController, ProductService productService) {
        this.authController = authController;
        this.productService = productService;
    }

    @PostMapping("/products/create")
    public Product CreateProduct(Product product){

        this.productService.createProduct(product);

        return product;



    }

    @GetMapping("/products/get")
    public List<Product> CreateProduct(){

       return this.productService.getProducts();


    }

    @GetMapping("products/get-product/{productIndex}")
    public Product getProduct(@PathVariable("productIndex") int productIndex)
    {

        return productService.getProduct(productIndex);
    }

    @PutMapping("products/update-product/{productIndex}")
    public Product updateProduct(@PathVariable("productIndex") int productIndex, Product product)
    {

        return productService.updateProduct(productIndex, product);
    }
    @DeleteMapping("products/delete-product/{productIndex}")
    public void deleteProduct(@PathVariable("productIndex") int index){

        productService.deleteProduct(index);
    }


}



