package com.ken.blcomiclibrary.service.impl;

import com.ken.blcomiclibrary.dao.BookDao;
import com.ken.blcomiclibrary.dto.BookRequest;
import com.ken.blcomiclibrary.model.Book;
import com.ken.blcomiclibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Book getBookByIsbn_jp(String isbn_jp) {
        return bookDao.getBookByIsbn_jp(isbn_jp);
    }

    @Override
    public List<Book> getBookByPublisher_jp(String publisher_jp) {
        return bookDao.getBookByPublisher_jp(publisher_jp);
    }

    @Override
    public String createBook(BookRequest bookRequest) {
        return bookDao.createBook(bookRequest);
    }
}
