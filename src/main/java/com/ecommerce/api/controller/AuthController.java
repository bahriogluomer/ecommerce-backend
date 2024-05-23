package com.ecommerce.api.controller;

import com.ecommerce.api.dto.RegistrationResponse;
import com.ecommerce.api.dto.UserLogin;
import com.ecommerce.api.dto.UserLoginResponse;
import com.ecommerce.api.dto.UserRegister;
import com.ecommerce.api.entity.User;
import com.ecommerce.api.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthenticationService authenticationService;

    @PostMapping("/signup")
    public RegistrationResponse signup(@RequestBody UserRegister userRegister) {
       User createdUser = authenticationService.register(userRegister.name(), userRegister.email(), userRegister.password());
       return new RegistrationResponse(createdUser.getEmail(), "User created successfully");
    }

    @PostMapping("/login")
    public UserLoginResponse login(@RequestBody UserLogin userLogin) {
        User user =  authenticationService.login(userLogin.email(), userLogin.password());
        return new UserLoginResponse(user.getEmail(), "User logged in successfully");
    }
}
