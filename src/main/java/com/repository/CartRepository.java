package com.repository;

import com.model.Cart;
import com.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

    Optional<Cart> findFirstByUserOrderByIdDesc(User user);
}
