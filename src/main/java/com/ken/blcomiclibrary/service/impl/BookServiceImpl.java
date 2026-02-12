package com.ken.blcomiclibrary.service.impl;

import com.ken.blcomiclibrary.dao.BookDao;
import com.ken.blcomiclibrary.dao.BookQueryParams;
import com.ken.blcomiclibrary.dto.BookRequest;
import com.ken.blcomiclibrary.model.Book;
import com.ken.blcomiclibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> getBooks(BookQueryParams bookQueryParams) {
        return bookDao.getBooks(bookQueryParams);
    }

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

    @Override
    public void updateBook(String isbn_jp, BookRequest bookRequest) {
        bookDao.updateBook(isbn_jp, bookRequest);
    }

    @Override
    public void deleteBook(String isbn_jp) {
        bookDao.deleteBook(isbn_jp);
    }
}
