package com.GroupProject.ecommerce.backend.model;

public class Cart {

    private Product product;
  private int numOfpProducts;


    public int getNumOfpProducts() {
        return numOfpProducts;
    }

    public void setNumOfpProducts(int numOfpProducts) {
        this.numOfpProducts = numOfpProducts;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
