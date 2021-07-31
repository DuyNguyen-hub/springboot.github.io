package com.spring.shoppingcart.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderLine implements Serializable {

    private Product product;
    private int count;

}
