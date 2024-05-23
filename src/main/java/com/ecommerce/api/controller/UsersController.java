package com.ecommerce.api.controller;

import com.ecommerce.api.entity.User;
import com.ecommerce.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UsersController {
    private UserService userService;
    @GetMapping
    public List<User> getAll() {
        return userService.findAll();
    }
}
