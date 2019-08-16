package com.service.impl;

import com.model.Cart;
import com.model.Product;
import com.model.User;
import com.repository.CartRepository;
import com.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public void add(Cart cart) {
        cartRepository.save(cart);
        logger.info(cart + " was added to DB");
    }

    @Override
    @Transactional
    public void addProduct(Cart cart, Product product) {
        cart.getProducts().add(product);
        cartRepository.save(cart);
        logger.info("Added " + product + " in cart " + cart);
    }

    @Override
    public int size(Cart cart) {
        return cart.getProducts().size();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cart> getCartByUser(User user) {
        return cartRepository.findFirstByUserOrderByIdDesc(user);
    }
}
