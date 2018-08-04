package com.dragomir.ecommerce.repositories;

import com.dragomir.ecommerce.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book, Long> {

    Page<Book> findByName(String name, Pageable pageable);

    List<Book> findByModel(String model);

}