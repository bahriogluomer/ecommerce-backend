package com.ecommerce.api.service;

import com.ecommerce.api.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getByParams(Integer category, String filter, String sort, Integer limit, Integer offset);
    Product save(Product product);
    Product findById(Long productId);
}
