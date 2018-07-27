package com.dragomir.ecommerce.repositories;

import com.dragomir.ecommerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(@Param("email") String email);

    Optional<User> findByUsernameOrEmail(@Param("username") String username, @Param("email") String email);

    List<User> findByIdIn(@Param("id") List<Long> userIds);

    Optional<User> findByUsername(@Param("username") String username);

    Boolean existsByUsername(@Param("username") String username);

    Boolean existsByEmail(@Param("email") String email);
}
