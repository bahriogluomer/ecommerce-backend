package com.ecommerce.api.service;

import com.ecommerce.api.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findById(Long id);
}
