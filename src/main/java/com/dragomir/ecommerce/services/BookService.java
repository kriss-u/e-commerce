package com.dragomir.ecommerce.services;

import com.dragomir.ecommerce.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface BookService {

    Book save(Book book);

    void delete(Book book);




    Page<Book> findByName(String name, PageRequest pageRequest);

    List<Book> findByModel(String model);

}