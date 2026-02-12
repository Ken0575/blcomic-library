package com.ken.blcomiclibrary.service;

import com.ken.blcomiclibrary.dto.BookRequest;
import com.ken.blcomiclibrary.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooks(String Publisher_jp, String search);
    Book getBookByIsbn_jp(String isbn_jp);
    List<Book> getBookByPublisher_jp(String publisher_jp);
    String createBook(BookRequest bookRequest);
    void updateBook(String isbn_jp, BookRequest bookRequest);
    void deleteBook(String isbn_jp);
}
