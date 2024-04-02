package com.GroupProject.ecommerce.backend.modelBody;

import com.GroupProject.ecommerce.backend.model.User;

public class LoginResponse {

    private User user;
    private boolean isAdmin;

    public LoginResponse(User user) {
        this.user = user;
    }

    public LoginResponse(User user, boolean isAdmin) {
        this.user = user;
        this.isAdmin = isAdmin;
    }

    public LoginResponse(){

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
