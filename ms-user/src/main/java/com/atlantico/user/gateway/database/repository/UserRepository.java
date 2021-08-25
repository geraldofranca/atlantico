package com.atlantico.user.gateway.database.repository;

import com.atlantico.user.gateway.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailEquals(String email);
}
