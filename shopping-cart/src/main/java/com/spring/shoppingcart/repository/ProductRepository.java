package com.spring.shoppingcart.repository;

import com.spring.shoppingcart.model.OrderLine;
import com.spring.shoppingcart.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private ArrayList<Product> products;
    private long nextId = 1;
    public ProductRepository() {
        products = new ArrayList<>();
        nextId = 1;

        initData();
    }

    public List<Product> getAll() {
        return products;
    }

    public Optional<Product> findById(long id) {
        return products.stream().filter(p -> p.getId() == id).findFirst();
    }



    public long createProduct(Product product) {
        product.setId(nextId);
        nextId += 1;
        products.add(product);
        return nextId;
    }

    public void initData() {
        createProduct(new Product("Màn hình Acer Nitro VG270-27inch", "", 4489000, "acer-nitro.jpeg"));
        createProduct(new Product("Màn hình Acer Predator X34P-34 inch", "", 28889000, "acer_predator.png"));
        createProduct(new Product("Màn hình Acer Predator XB253QGX-25 inch", "", 11190000, "acer_predator01.jpeg"));
        createProduct(new Product("Màn hình Acer ED273A-27 inch", "", 6989000, "acer_ed273a.jpeg"));
        createProduct(new Product("Màn hình Samsung LS24F350FHEXXV-23.6 inch", "", 3659000, "samsung_ls24.png"));
        createProduct(new Product("BÀN PHÍM CƠ CORSAIR K63 CHERRY MX RED (USB/RED LED)", "", 1989000, "keybroad_1.jpeg"));
        createProduct(new Product("BÀN PHÍM CƠ CORSAIR K63 WIRELESS - (USB/BLUE LED)", "", 2669000, "keyboard_2.jpeg"));
        createProduct(new Product("BÀN PHÍM CƠ CHƠI GAME CORSAIR K95 RGB PLATINUM", "", 3149000, "keyboard_3.jpeg"));
    }
}
