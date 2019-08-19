package com.service;

import com.model.Cart;
import com.model.Product;
import com.model.User;

import java.util.Optional;

public interface CartService {

    void add(Cart cart);

    void addProduct(Cart cart, Product product);

    int size(Cart cart);

    Optional<Cart> getCartByUser(User user);
}
