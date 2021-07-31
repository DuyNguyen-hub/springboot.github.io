package com.spring.session_demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import com.spring.session_demo.model.Cart;
import com.spring.session_demo.model.OrderLine;
import com.spring.session_demo.model.Product;
import com.spring.session_demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartService {
    @Autowired private ProductRepository productRepository;

    public void addToCart(Long id,  HttpSession session) {
        HashMap<Long, OrderLine> cart;

        var rawCart = session.getAttribute("CART");

        if (rawCart instanceof HashMap) {
            cart = (HashMap<Long, OrderLine>) rawCart;
        } else {
            cart = new HashMap<>();
        }

        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            OrderLine orderLine = cart.get(id);
            if (orderLine == null) {
                cart.put(id, new OrderLine(product.get(), 1));
            } else {
                orderLine.increaseByOne();
                cart.put(id, orderLine);
            }
        }

        session.setAttribute("CART", cart);
    }

    public int countItemInCart(HttpSession session) {
        HashMap<Long, OrderLine> cart;

        var rawCart = session.getAttribute("CART");

        if (rawCart instanceof HashMap) {
            cart = (HashMap<Long, OrderLine>) rawCart;
            return cart.values().stream().mapToInt(OrderLine::getCount).sum();
        } else {
            return 0;
        }
    }

    public Cart getCart(HttpSession session) {
        HashMap<Long, OrderLine> cart;

        var rawCart = session.getAttribute("CART");

        if (rawCart instanceof HashMap) {
            cart = (HashMap<Long, OrderLine>) rawCart;
            return new Cart(
                    cart.values().stream().collect(Collectors.toList()),  //danh sách các mặt hàng mua
                    0.01f, //%Giảm giá
                    true   //Có tính thuế VAT không?
            );
        } else {
            return new Cart();
        }
    }
}