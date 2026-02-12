package com.ken.blcomiclibrary.service;

import com.ken.blcomiclibrary.dao.BookQueryParams;
import com.ken.blcomiclibrary.dto.BookRequest;
import com.ken.blcomiclibrary.model.Book;

import java.util.List;

public interface BookService {

    Integer countBooks(BookQueryParams bookQueryParams);

    List<Book> getBooks(BookQueryParams bookQueryParams);

    Book getBookByIsbn_jp(String isbn_jp);

    List<Book> getBookByPublisher_jp(String publisher_jp);

    String createBook(BookRequest bookRequest);

    void updateBook(String isbn_jp, BookRequest bookRequest);

    void deleteBook(String isbn_jp);

}
