package com.ecommerce.api.service;

import com.ecommerce.api.entity.Role;
import com.ecommerce.api.exceptions.ApiException;
import com.ecommerce.api.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new ApiException("Role not found with id " + id, HttpStatus.NOT_FOUND));
    }
}
