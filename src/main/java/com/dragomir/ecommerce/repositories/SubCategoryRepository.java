package com.dragomir.ecommerce.repositories;

import com.dragomir.ecommerce.models.SubCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends CrudRepository<SubCategory, Long> {

}
