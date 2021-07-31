package com.spring.shoppingcart.model;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import lombok.Data;
@Data
public class Cart {
    private List<OrderLine> orderLines;
    private long rawTotal;
    private long discount;
    private long vatTax;
    private long total;

    public Cart() {
        orderLines = Collections.emptyList();
        rawTotal = 0;
        discount = 0;
        vatTax = 0;
        total = 0;
    }

    public Cart(List<OrderLine> orderLines, double discountPercentage, boolean isVATIncluded){
        this.orderLines = orderLines;
        rawTotal = 0;

        orderLines.stream().forEach(orderLine -> {
            rawTotal += orderLine.getCount() * orderLine.getProduct().getPrice();
        });

        discount = (long) Math.round(rawTotal * discountPercentage);

        if (isVATIncluded) {
            vatTax = (long) Math.round((rawTotal - discount) * 0.01f);
        } else {
            vatTax = 0;
        }

        total = rawTotal - discount + vatTax;
    }

    public OrderLine getItem(Product p){
        for(OrderLine item:orderLines){
            if(item.getProduct().getId() == p.getId()){
                return item;
            }
        }
        return null;
    }

    public void update(Product p){
       OrderLine item = getItem(p);
       if(item != null){

           item.setCount(item.getCount()+1);
       }
    }


    public void removecount(Product product) {
        OrderLine item = getItem(product);
        if(item != null){
            if(item.getCount() > 1) {
                item.setCount(item.getCount() - 1);
            }else {
                item.setCount(1);
            }
        }
    }
}
