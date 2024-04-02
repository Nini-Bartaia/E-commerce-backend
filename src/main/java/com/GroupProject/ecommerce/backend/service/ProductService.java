package com.GroupProject.ecommerce.backend.service;

import com.GroupProject.ecommerce.backend.model.Product;
import com.GroupProject.ecommerce.backend.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public static final List<Product> products = new ArrayList<>();

    public Product createProduct(Product productBody){

        Product product= new Product();

        product.setName(productBody.getName());
        product.setPrice(productBody.getPrice());
        product.setStockQuantity(productBody.getStockQuantity());

        products.add(product);
        return product;


    }
    public Product getProduct(int index){

        return products.get(index);
    }

    public List<Product> getProducts(){

        return products;
    }

    public Product updateProduct(@PathVariable("productIndex") int index, @RequestBody Product product) {

        if (index < products.size() && index > -1) {

            Product oldProduct = products.get(index);
            oldProduct.setPrice(product.getPrice());
            oldProduct.setName(product.getName());
            oldProduct.setStockQuantity(product.getStockQuantity());

        }

        return product;

    }

    public void deleteProduct(int index) {

        products.remove(index);
    }


}
