package com.ecommerce.api.controller;

import com.ecommerce.api.entity.Product;
import com.ecommerce.api.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @GetMapping
    public List<Product> getByParams(@RequestParam(required = false) Integer category,
                                     @RequestParam(required = false) String filter,
                                     @RequestParam(required = false) String sort,
                                     @RequestParam(required = false, defaultValue = "20") Integer limit,
                                     @RequestParam(required = false, defaultValue = "0") Integer offset) {
        return productService.getByParams(category, filter, sort, limit, offset);
    }

    @GetMapping("/id")
    public Product findById(Long productId) {
        return productService.findById(productId);
    }
}
