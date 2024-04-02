package com.GroupProject.ecommerce.backend.modelBody;

public class OrderCreationRequest {
    private LoginBody user;
    private int productId;

    public LoginBody getUser() {
        return user;
    }

    public void setUser(LoginBody user) {
        this.user = user;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
