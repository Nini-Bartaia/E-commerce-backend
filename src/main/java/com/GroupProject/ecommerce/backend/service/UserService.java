package com.GroupProject.ecommerce.backend.service;

import com.GroupProject.ecommerce.backend.modelBody.LoginBody;
import com.GroupProject.ecommerce.backend.model.User;
import com.GroupProject.ecommerce.backend.modelBody.RegisterBody;
import com.GroupProject.ecommerce.backend.modelBody.UserType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    public static final List<User> users = new ArrayList<>();

    public User registerUser(RegisterBody registrationBody){

        User user= new User();

        user.setUsername(registrationBody.getUsername());
        user.setType(registrationBody.getType());
        user.setPassword(registrationBody.getPassword());

        users.add(user);
        return user;


    }


    public User login(LoginBody loginBody) {

        for (User user : users) {
            if (user.getUsername().equals(loginBody.getUsername()) && user.getPassword().equals(loginBody.getPassword())) {
                // Return the user if username and password match
                return user;
            }
        }
        // Return null if no matching user found
        return null;
    }

    public List<User> getUsers(){

        return users;
    }


    public static String getUserRole(UserType type) {
        if (type == UserType.ADMIN) {
            return "ROLE_ADMIN";
        } else {
            return "ROLE_USER";
        }
    }

}

