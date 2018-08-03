package com.dragomir.ecommerce.repositories;

import com.dragomir.ecommerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Optional<User> findByUsername(@Param("username") String username);

    User findByUsername(@Param(value = "username") String username);
    Boolean existsUserByUsername(@Param(value = "username") String username);
    Boolean existsUserByEmail(@Param(value = "email") String email);
    User findByEmail(@Param(value = "email") String email);

    User findUserById(@Param(value = "id") Long userId);
}
