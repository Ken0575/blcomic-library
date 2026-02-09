package com.ken.blcomiclibrary.dao.impl;

import com.ken.blcomiclibrary.dao.BookDao;
import com.ken.blcomiclibrary.model.Book;
import com.ken.blcomiclibrary.rowmapper.BookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BookDaoImpl implements BookDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Book getBookByIsbn_jp(String isbn_jp) {
        String sql = "SELECT * FROM BLComics WHERE isbn_jp = :isbn_jp";

        Map<String,Object> map = new HashMap<>();
        map.put("isbn_jp", isbn_jp);

        List<Book> booklist = namedParameterJdbcTemplate.query(sql, map, new BookRowMapper());

        if(booklist.isEmpty()){
            return null;
        } else {
            return booklist.getFirst();
        }
    }

    @Override
    public List<Book> getBookByPublisher_jp(String publisher_jp) {
        String sql = "SELECT * FROM BLComics WHERE publisher_jp = :publisher_jp";
        Map<String,Object> map = new HashMap<>();
        map.put("publisher_jp", publisher_jp);
        List<Book> booklist = namedParameterJdbcTemplate.query(sql, map, new BookRowMapper());
        if(booklist.isEmpty()){
            return null;
        } else  {
            return booklist;
        }
    }
}
