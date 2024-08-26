package com.devs.data.repository;

import com.devs.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Users extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
