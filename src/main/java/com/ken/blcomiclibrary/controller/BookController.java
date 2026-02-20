package com.ken.blcomiclibrary.controller;

import com.ken.blcomiclibrary.dao.BookQueryParams;
import com.ken.blcomiclibrary.dto.BookRequest;
import com.ken.blcomiclibrary.model.Book;
import com.ken.blcomiclibrary.service.BookService;
import com.ken.blcomiclibrary.util.Page;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<Page<Book>> getBooks(
            // Filtering
            @RequestParam(required = false) String publisher_jp,
            @RequestParam(required = false) String publisher_tw,
            @RequestParam(required = false) String search,

            // Sorting
            @RequestParam(defaultValue = "published_date_jp") String order,
            @RequestParam(defaultValue = "DESC") String sort,

            // Pagination
            @RequestParam(defaultValue = "12") @Max(500) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset
    ){
        BookQueryParams bookQueryParams = new BookQueryParams();
        bookQueryParams.setPublisher_jp(publisher_jp);
        bookQueryParams.setPublisher_tw(publisher_tw);
        bookQueryParams.setSearch(search);
        bookQueryParams.setOrder(order);
        bookQueryParams.setSort(sort);
        bookQueryParams.setLimit(limit);
        bookQueryParams.setOffset(offset);

        List<Book> booklist = bookService.getBooks(bookQueryParams);

        Integer total = bookService.countBooks(bookQueryParams);

        Page<Book> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResult(booklist);

        // return HTTP 200 OK
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }
    @GetMapping("/books/tw")
    public ResponseEntity<Page<Book>> getTaiwanBooks(
            // Filtering
            @RequestParam(required = false) String publisher_jp,
            @RequestParam(required = false) String publisher_tw,
            @RequestParam(required = false) String search,

            // Sorting
            @RequestParam(defaultValue = "published_date_tw") String order,
            @RequestParam(defaultValue = "DESC") String sort,

            // Pagination
            @RequestParam(defaultValue = "12") @Max(500) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset
    ){
        BookQueryParams bookQueryParams = new BookQueryParams();
        bookQueryParams.setPublisher_jp(publisher_jp);
        bookQueryParams.setPublisher_tw(publisher_tw);
        bookQueryParams.setSearch(search);
        bookQueryParams.setOrder(order);
        bookQueryParams.setSort(sort);
        bookQueryParams.setLimit(limit);
        bookQueryParams.setOffset(offset);

        List<Book> booklist = bookService.getBooks(bookQueryParams);

        Integer total = bookService.countBooks(bookQueryParams);

        Page<Book> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResult(booklist);

        // return HTTP 200 OK
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }


    // 設定HTTP的GET Request
    @GetMapping("/books/isbn_jp/{isbn_jp}")
    public ResponseEntity<Book> getBookByIsbn_jp(@PathVariable String isbn_jp) {
        Book book = bookService.getBookByIsbn_jp(isbn_jp);

        // Check if Database has the book.
        if(book == null){
            // return HTTP 404 NOT FOUND
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            // return HTTP 200 OK
            return ResponseEntity.status(HttpStatus.OK).body(book);
        }
    }

    @GetMapping("/books/publisher_jp/{publisher_jp}")
    public ResponseEntity<List<Book>> getBookByPublisher_jp(@PathVariable String publisher_jp) {
        List<Book> booksList =  bookService.getBookByPublisher_jp(publisher_jp);

        // Check if Database has the book.
        if(booksList.isEmpty()){
            // return HTTP 404 NOT FOUND
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            // return HTTP 200 OK
            return ResponseEntity.status(HttpStatus.OK).body(booksList);
        }
    }

    // 設定HTTP的POST Request
    @PostMapping("/books/create")
    public ResponseEntity<Book> createBook(@RequestBody @Valid BookRequest bookRequest) { // @Valid要記得加入，讓@NotNull生效
        String isbn_jp = bookService.createBook(bookRequest);
        Book book = bookService.getBookByIsbn_jp(isbn_jp);
        // return HTTP 201 CREATED
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    // Setup PUT Request (Update)
    @PutMapping("books/update/{isbn_jp}")
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
    @DeleteMapping("/books/delete/{isbn_jp}")
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
