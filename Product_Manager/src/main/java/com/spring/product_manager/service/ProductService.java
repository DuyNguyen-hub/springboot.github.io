package com.spring.product_manager.service;

import com.spring.product_manager.model.Product;
import com.spring.product_manager.model.ProductAddForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Page<Product>> list(Pageable pageable);

    Product add(Product request);

    void delete(Long id);
}
