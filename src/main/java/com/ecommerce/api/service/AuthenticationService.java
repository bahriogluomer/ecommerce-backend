package com.ecommerce.api.service;


import com.ecommerce.api.entity.Role;
import com.ecommerce.api.entity.User;
import com.ecommerce.api.exceptions.ApiException;
import com.ecommerce.api.repository.RoleRepository;
import com.ecommerce.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@AllArgsConstructor
@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(String name, String email, String password) {
        Optional<User> user = userRepository.findUserByEmail(email);
        if(user.isPresent()) {
            throw new RuntimeException("User already exists");
        }

        String encodedPassword = passwordEncoder.encode(password);
        Role role = roleRepository.findByAuthority("USER").orElseThrow(() -> new ApiException("Role not found", HttpStatus.NOT_FOUND));

        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(encodedPassword);
        newUser.setRoles(roles);
        return userRepository.save(newUser);
    }

    /* write a method for login */
    public User login(String email, String password) {

        User user = userRepository.findUserByEmail(email).orElseThrow(() -> new ApiException("email not found", HttpStatus.UNAUTHORIZED));
        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new ApiException("Invalid password", HttpStatus.UNAUTHORIZED);
        }
        return user;
    }

}
