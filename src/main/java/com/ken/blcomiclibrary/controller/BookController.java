package com.ken.blcomiclibrary.controller;

import com.ken.blcomiclibrary.dto.BookRequest;
import com.ken.blcomiclibrary.model.Book;
import com.ken.blcomiclibrary.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // 設定HTTP的POST Request
    @PostMapping("/book/create")
    public ResponseEntity<Book> createBook(@RequestBody @Valid BookRequest bookRequest) { // @Valid要記得加入，讓@NotNull生效
        String isbn_jp = bookService.createBook(bookRequest);
        Book book = bookService.getBookByIsbn_jp(isbn_jp);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    // Setup PUT Request (Update)
    @PutMapping("book/update/{isbn_jp}")
    public ResponseEntity<Book> updateBook(@PathVariable String isbn_jp, @RequestBody @Valid BookRequest bookRequest) {
        // Check if Database has the book.
        Book book = bookService.getBookByIsbn_jp(isbn_jp);
        if(book == null){
            // return HTTP 404 NOT FOUND
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Update Book info
        bookService.updateBook(isbn_jp, bookRequest);
        Book updatedbook = bookService.getBookByIsbn_jp(isbn_jp);

        // return HTTP 200 OK
        return ResponseEntity.status(HttpStatus.OK).body(updatedbook);
    }

    //Setup DELETE Request
    @DeleteMapping("/book/delete/{isbn_jp}")
    public ResponseEntity<Book> deleteBook(@PathVariable String isbn_jp) {
        // Check if Database has the book.
        Book book = bookService.getBookByIsbn_jp(isbn_jp);
        if(book == null){
            // return HTTP 404 NOT FOUND
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Delete Book info
        bookService.deleteBook(isbn_jp);
        Book deletedbook = bookService.getBookByIsbn_jp(isbn_jp);

        // return HTTP 204 NO CONTENT
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(deletedbook);
    }
}
