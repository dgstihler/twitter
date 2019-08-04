package com.backend.twitter.repository;

import com.backend.twitter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {

    User findByEmail(String username);
}
