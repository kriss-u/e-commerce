package com.dragomir.ecommerce.repositories;

import com.dragomir.ecommerce.models.OrderedProductId;
import com.dragomir.ecommerce.models.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {
}
