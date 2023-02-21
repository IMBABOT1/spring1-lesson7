package com.geekbrains.spring.web.cart;

import com.geekbrains.spring.web.entities.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    private List<Product> cart;

    @PostConstruct
    public void init() {
        cart = new ArrayList<>();
    }


    public List<Product> getCart() {
        return cart;
    }

    public void addToCart(Product product) {
        cart.add(product);
    }

    public void remove(Long id){
        cart.remove(id);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Product p : cart) {
            sb.append(p);
        }
        sb.append("]");
        return sb.toString();
    }
}
