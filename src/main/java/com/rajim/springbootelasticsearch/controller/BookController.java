package com.rajim.springbootelasticsearch.controller;

import com.rajim.springbootelasticsearch.entity.Book;
import com.rajim.springbootelasticsearch.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author rajim on 10/12/18
 */
@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/{id}")
    public Map<String, Object> getBookById(@PathVariable String id){
        return bookService.getBookById(id);
    }


    @PostMapping
    public Book insertBook(@RequestBody Book book) throws Exception {
        return bookService.insertBook(book);
    }


    @PutMapping("/{id}")
    public Map<String, Object> updateBookById(@RequestBody Book book,
                                              @PathVariable String id) {
        return bookService.updateBookById(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable String id) {
        bookService.deleteBookById(id);
    }

}
