package com.dragomir.ecommerce.repositories;

import com.dragomir.ecommerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Optional<User> findByUsername(@Param("username") String username);

    User findByUsername(String username);

}
