package com.backend.twitter.repository;

import com.backend.twitter.entity.Role;
import com.backend.twitter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
