package com.ken.blcomiclibrary.rowmapper;

import com.ken.blcomiclibrary.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setAuthor(rs.getString("author"));
        book.setTitle_jp(rs.getString("title_jp"));
        book.setPublisher_jp(rs.getString("publisher_jp"));
        book.setPublished_date_jp(rs.getDate("published_date_jp"));
        book.setIsbn_jp(rs.getString("isbn_jp"));
        book.setTitle_tw(rs.getString("title_tw"));
        book.setPublisher_tw(rs.getString("publisher_tw"));
        book.setPublished_date_tw(rs.getDate("published_date_tw"));
        book.setIsbn_tw(rs.getString("isbn_tw"));

        return book;
    }
}
