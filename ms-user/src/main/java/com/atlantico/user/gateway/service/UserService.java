package com.atlantico.user.gateway.service;

import com.atlantico.user.gateway.database.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);

    List<User> list();

    Optional<User> findByEmail(String email);
}
