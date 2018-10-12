package com.rajim.springbootelasticsearch.service;

import com.rajim.springbootelasticsearch.entity.Book;

import java.util.Map;

/**
 * @author rajim on 10/11/18
 */
public interface BookService {

    Map<String,Object> getBookById(String id);

    Book insertBook(Book book);

    Map<String,Object> updateBookById(String id, Book book);

    void deleteBookById(String id);
}
