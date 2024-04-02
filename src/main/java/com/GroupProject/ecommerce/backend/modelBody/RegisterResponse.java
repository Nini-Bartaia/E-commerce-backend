package com.GroupProject.ecommerce.backend.modelBody;

import com.GroupProject.ecommerce.backend.model.User;

public class RegisterResponse {


    private User user;

    public RegisterResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
