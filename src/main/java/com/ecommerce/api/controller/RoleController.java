package com.ecommerce.api.controller;


import com.ecommerce.api.entity.Role;
import com.ecommerce.api.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/roles")
public class RoleController {
    private RoleService roleService;
    @GetMapping
    public List<Role> findAll() {
        return roleService.findAll();
    }
}
