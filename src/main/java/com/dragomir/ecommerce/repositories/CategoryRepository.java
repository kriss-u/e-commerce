package com.dragomir.ecommerce.repositories;

import com.dragomir.ecommerce.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
