package com.ecommerce.api.service;

import com.ecommerce.api.entity.Product;
import com.ecommerce.api.exceptions.ApiException;
import com.ecommerce.api.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public Product save(Product product) {
        if(product == null) {
            throw new ApiException("Product cannot be null", HttpStatus.BAD_REQUEST);
        }
        return productRepository.save(product);
    }

    public Product findById(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new ApiException("Product not found", HttpStatus.NOT_FOUND));
    }
    public List<Product> getByParams(Integer category, String filter, String sort, Integer limit, Integer offset) {
        Pageable pageable = Pageable.ofSize(limit).withPage(offset);
        return productRepository.findByParams(category, filter, sort, pageable).toList();
    }
}
