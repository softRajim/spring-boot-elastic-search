package com.rajim.springbootelasticsearch.service.impl;

import com.rajim.springbootelasticsearch.entity.Book;
import com.rajim.springbootelasticsearch.repository.BookRepository;
import com.rajim.springbootelasticsearch.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author rajim on 10/11/18
 */
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Map<String, Object> getBookById(String id) {
        return null;
    }

    @Override
    public Book insertBook(Book book) {
        return bookRepository.insert(book);
    }

    @Override
    public Map<String, Object> updateBookById(String id, Book book) {
        return null;
    }

    @Override
    public void deleteBookById(String id) {

    }

}
