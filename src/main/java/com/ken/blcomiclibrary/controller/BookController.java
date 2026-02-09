package com.ken.blcomiclibrary.controller;

import com.ken.blcomiclibrary.model.Book;
import com.ken.blcomiclibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book/{isbn_jp}")
    public ResponseEntity<Book> getBook(@PathVariable String isbn_jp) {
        Book book = bookService.getBookByIsbn_jp(isbn_jp);
        if(book == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(book);
        }
    }
}
