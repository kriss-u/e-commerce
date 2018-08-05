package com.dragomir.ecommerce.repositories;

import com.dragomir.ecommerce.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Boolean existsByUsername(@Param("username") String username);
}
