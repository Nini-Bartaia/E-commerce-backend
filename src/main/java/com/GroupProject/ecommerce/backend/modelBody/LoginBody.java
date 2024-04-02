package com.GroupProject.ecommerce.backend.modelBody;

public class LoginBody {


    private String username;

    private String password;

    private UserType type;

    public UserType getType() {
        return type;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
