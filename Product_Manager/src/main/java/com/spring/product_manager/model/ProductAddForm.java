package com.spring.product_manager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductAddForm {

    private String name;

    private String brand;

    private String madein;

    private Double price;
}
