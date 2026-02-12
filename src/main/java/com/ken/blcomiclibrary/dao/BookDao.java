package com.ken.blcomiclibrary.dao;

import com.ken.blcomiclibrary.dto.BookRequest;
import com.ken.blcomiclibrary.model.Book;

import java.util.List;

public interface BookDao {

    List<Book> getBooks();
    Book getBookByIsbn_jp(String isbn_jp);
    List<Book> getBookByPublisher_jp(String publisher_jp);
    String createBook(BookRequest bookRequest);
    void updateBook(String isbn_jp, BookRequest bookRequest);
    void deleteBook(String isbn_jp);
}
