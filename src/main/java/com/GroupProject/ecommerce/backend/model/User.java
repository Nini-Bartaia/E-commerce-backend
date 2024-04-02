package com.GroupProject.ecommerce.backend.model;

import jakarta.validation.constraints.*;
import com.GroupProject.ecommerce.backend.modelBody.UserType;

public class User {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters")
    private String username;
    @NotNull

    private UserType type; // can be either "admin" or "user"
    private double budget=1000;
    @NotNull
    @NotBlank
    @Size(min = 5, max = 16, message = "Invalid Name: Must be of 5 - 16 characters")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserType getType() {
        return type;
    }

    public void setType( UserType type) {
        this.type = type;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
