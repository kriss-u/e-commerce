package com.dragomir.ecommerce.services;

import com.dragomir.ecommerce.models.Book;
import com.dragomir.ecommerce.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void delete(Book book) {
        bookRepository.delete(book);
    }


    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    public Page<Book> findByName(String name, PageRequest pageRequest) {
        return bookRepository.findByName(name, pageRequest);
    }

    public List<Book> findByModel(String model) {
        return bookRepository.findByModel(model);
    }

}