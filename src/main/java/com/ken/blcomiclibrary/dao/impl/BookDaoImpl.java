package com.ken.blcomiclibrary.dao.impl;

import com.ken.blcomiclibrary.dao.BookDao;
import com.ken.blcomiclibrary.dto.BookRequest;
import com.ken.blcomiclibrary.model.Book;
import com.ken.blcomiclibrary.rowmapper.BookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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

        Map<String, Object> map = new HashMap<>();
        map.put("isbn_jp", isbn_jp);

        List<Book> booklist = namedParameterJdbcTemplate.query(sql, map, new BookRowMapper());

        if (booklist.isEmpty()) {
            return null;
        } else {
            return booklist.getFirst();
        }
    }

    @Override
    public List<Book> getBookByPublisher_jp(String publisher_jp) {
        String sql = "SELECT * FROM BLComics WHERE publisher_jp = :publisher_jp";
        Map<String, Object> map = new HashMap<>();
        map.put("publisher_jp", publisher_jp);
        List<Book> booklist = namedParameterJdbcTemplate.query(sql, map, new BookRowMapper());
        if (booklist.isEmpty()) {
            return null;
        } else {
            return booklist;
        }
    }

    @Override
    public String createBook(BookRequest bookRequest) {
        String sql = "INSERT INTO BLComics (author, title_jp, publisher_jp, published_date_jp, isbn_jp, title_tw, publisher_tw, published_date_tw, isbn_tw) VALUES (:author, :title_jp, :publisher_jp, :published_date_jp, :isbn_jp, :title_tw, :publisher_tw, :published_date_tw, :isbn_tw)";
        Map<String, Object> map = new HashMap<>();
        map.put("author", bookRequest.getAuthor());
        map.put("title_jp", bookRequest.getTitle_jp());
        map.put("publisher_jp", bookRequest.getPublisher_jp());
        map.put("published_date_jp", bookRequest.getPublished_date_jp());
        map.put("isbn_jp", bookRequest.getIsbn_jp());
        map.put("title_tw", bookRequest.getTitle_tw());
        map.put("publisher_tw", bookRequest.getPublisher_tw());
        map.put("published_date_tw", bookRequest.getPublished_date_tw());
        map.put("isbn_tw", bookRequest.getIsbn_tw());

        // 建立KeyHolder儲存、接收新物件的Primary Key(id)
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        return bookRequest.getIsbn_jp();
    }
}
