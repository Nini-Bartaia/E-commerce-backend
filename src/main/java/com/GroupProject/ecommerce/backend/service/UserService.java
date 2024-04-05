package com.GroupProject.ecommerce.backend.service;

import com.GroupProject.ecommerce.backend.modelBody.LoginBody;
import com.GroupProject.ecommerce.backend.model.User;
import com.GroupProject.ecommerce.backend.modelBody.RegisterBody;
import com.GroupProject.ecommerce.backend.modelBody.UserType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {


    public static final List<User> users = new ArrayList<>();

    public static UserType type;

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
                type=user.getType();
                return user;
            }
        }

        // Return null if no matching user found
        return null;
    }

    public List<User> getUsers(){

        return users;
    }

    public boolean getType(){

        if(Objects.equals(type.toString(), "ADMIN")){

            return true;
        }else{
            return false;
        }
    }


    public static String getUserRole(UserType type) {
        if (type == UserType.ADMIN) {
            return "ROLE_ADMIN";
        } else {
            return "ROLE_USER";
        }
    }

}

