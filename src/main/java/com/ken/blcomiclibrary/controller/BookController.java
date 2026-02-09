package com.ken.blcomiclibrary.controller;

import com.ken.blcomiclibrary.model.Book;
import com.ken.blcomiclibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // 設定HTTP的GET Request
    @GetMapping("/book/isbn_jp/{isbn_jp}")
    public ResponseEntity<Book> getBookByIsbn_jp(@PathVariable String isbn_jp) {
        Book book = bookService.getBookByIsbn_jp(isbn_jp);

        if(book == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(book);
        }
    }

    @GetMapping("/book/publisher_jp/{publisher_jp}")
    public ResponseEntity<List<Book>> getBookByPublisher_jp(@PathVariable String publisher_jp) {
        List<Book> booksList =  bookService.getBookByPublisher_jp(publisher_jp);
        if(booksList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(booksList);
        }
    }
}
