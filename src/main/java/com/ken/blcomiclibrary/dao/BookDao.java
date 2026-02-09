package com.ken.blcomiclibrary.dao;

import com.ken.blcomiclibrary.dto.BookRequest;
import com.ken.blcomiclibrary.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;

public interface BookDao {
    Book getBookByIsbn_jp(String isbn_jp);
    List<Book> getBookByPublisher_jp(String publisher_jp);
    String createBook(BookRequest bookRequest);
}
