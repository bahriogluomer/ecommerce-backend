package com.ecommerce.api.repository;

import com.ecommerce.api.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT r FROM Role r WHERE r.authority = :authority")
    Optional<Role> findByAuthority(String authority);

    @Override
    @Query("SELECT r FROM Role r")
    List<Role> findAll();

    @Query("SELECT r FROM Role r WHERE r.id = :id")
    Optional<Role> findById(Long id);

}
