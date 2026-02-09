package com.ken.blcomiclibrary.service;

import com.ken.blcomiclibrary.model.Book;

public interface BookService {
    Book getBookByIsbn_jp(String isbn_jp);
}
