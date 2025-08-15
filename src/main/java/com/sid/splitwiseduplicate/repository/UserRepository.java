package com.sid.splitwiseduplicate.repository;

import com.sid.splitwiseduplicate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}
