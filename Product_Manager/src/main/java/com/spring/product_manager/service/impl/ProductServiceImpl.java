package com.spring.product_manager.service.impl;

import com.spring.product_manager.model.Product;
import com.spring.product_manager.repository.ProductRepo;
import com.spring.product_manager.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Optional<Page<Product>> list(Pageable pageable) {
        Page<Product> page = null;
        try {
            page = productRepo.findAll(pageable);
        } catch (Exception ex) {
            log.error("get all car error: " + ex.getMessage());
        }
        return Optional.ofNullable(page);
    }

    @Override
    public Product add(Product request) {
        Product productCreated = null;
       try {
           Product product = new Product();
           product.setName(request.getName());
           product.setBrand(request.getBrand());
           product.setMadein(request.getMadein());
           product.setPrice(request.getPrice());

          productCreated = productRepo.save(product);
       }catch (Exception ex){
           log.info(ex.getMessage());
       }
       return productCreated;


    }

    @Override
    public void delete(Long id) {
        productRepo.deleteById(id);
    }

}
