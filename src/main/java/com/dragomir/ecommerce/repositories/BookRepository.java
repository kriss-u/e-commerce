package com.dragomir.ecommerce.repositories;

import com.dragomir.ecommerce.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BookRepository extends ElasticsearchRepository<Book, Long> {

    Page<Book> findByNameContainingOrModelContainingOrBrandContainingOrSubcategoryContaining(@Param("name") String name, @Param("model") String model,@Param("brand") String brand,@Param("subcategory") String subcategory, Pageable pageable);
    //Page<Book>
    Page<Book> findByNameContainingOrModelContainingOrBrandContainingOrSubcategoryContainingOrderByCost(@Param("name") String name, @Param("model") String model,@Param("brand") String brand,@Param("subcategory") String subcategory,@Param("cost") Long cost, Pageable pageable);

    Page<Book> findByNameContainingOrModelContainingOrBrandContainingOrSubcategoryContainingOrderByCostDesc(@Param("name") String name, @Param("model") String model,@Param("brand") String brand,@Param("subcategory") String subcategory,@Param("cost") Long cost, Pageable pageable);


}