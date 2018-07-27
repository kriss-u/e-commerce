package com.dragomir.ecommerce.repositories;

import com.dragomir.ecommerce.models.Role;
import com.dragomir.ecommerce.models.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(@Param("name") RoleName roleName);
}
