package com.GroupProject.ecommerce.backend.controller;

import com.GroupProject.ecommerce.backend.model.User;
import com.GroupProject.ecommerce.backend.modelBody.*;
import com.GroupProject.ecommerce.backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;



@RestController

public class AuthController {

    private final UserService userService;

    private static final ThreadLocal<User> userHolder = new ThreadLocal<>();


    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public RegisterResponse registerUser(@RequestBody @Valid RegisterBody registerBody){

        User user = userService.registerUser(registerBody);
        userHolder.set(user);

        return new RegisterResponse(user);

    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginBody loginBody) {
        User user = userService.login(loginBody);
        userHolder.set(user);
        return  new LoginResponse(user, userService.getType());
    }


    public static boolean isAdmin() {
        User user = userHolder.get();
        if (user == null) {
            return false;
        }
        return user.getType() == UserType.ADMIN;
    }


}
