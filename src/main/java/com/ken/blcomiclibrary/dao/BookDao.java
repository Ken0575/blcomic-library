package com.ken.blcomiclibrary.dao;

import com.ken.blcomiclibrary.model.Book;
import org.springframework.stereotype.Component;

public interface BookDao {
    Book getBookByIsbn_jp(String isbn_jp);
}
