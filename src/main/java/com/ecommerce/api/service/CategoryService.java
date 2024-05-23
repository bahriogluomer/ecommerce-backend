package com.ecommerce.api.service;

import com.ecommerce.api.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Long id);
}
