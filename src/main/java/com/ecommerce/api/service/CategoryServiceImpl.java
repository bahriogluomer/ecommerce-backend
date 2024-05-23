package com.ecommerce.api.service;

import com.ecommerce.api.entity.Category;
import com.ecommerce.api.exceptions.ApiException;
import com.ecommerce.api.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ApiException("Category not found", HttpStatus.NOT_FOUND));
    }

}
