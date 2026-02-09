package com.ken.blcomiclibrary.service;

import com.ken.blcomiclibrary.model.Book;

import java.util.List;

public interface BookService {
    Book getBookByIsbn_jp(String isbn_jp);
    List<Book> getBookByPublisher_jp(String publisher_jp);
}
