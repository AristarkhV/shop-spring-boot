package com.service;

import com.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void add(User user);

    void edit(User user);

    void delete(Long id);

    Optional<User> getById(Long id);

    Optional<User> getByEmail(String email);

    List<User> getAll();
}
