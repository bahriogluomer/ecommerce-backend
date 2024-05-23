package com.ecommerce.api.repository;

import com.ecommerce.api.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE (:category IS NULL OR p.category = :category) AND (:filter IS NULL OR p.name LIKE %:filter%) " +
            "ORDER BY CASE WHEN :sort = 'price:asc' THEN p.price END ASC, " +
            "CASE WHEN :sort = 'price:desc' THEN p.price END DESC, " +
            "CASE WHEN :sort = 'rating:asc' THEN p.rating END ASC, " +
            "CASE WHEN :sort = 'rating:desc' THEN p.rating END DESC")
    Page<Product> findByParams(@Param("category") Integer category,
                               @Param("filter") String filter, @Param("sort") String sort,
                               Pageable pageable);
}
