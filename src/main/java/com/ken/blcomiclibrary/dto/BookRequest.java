package com.ken.blcomiclibrary.dto;

import jakarta.validation.constraints.NotNull;

public class BookRequest {

    @NotNull
    private String author;

    @NotNull
    private String title_jp;

    @NotNull
    private String publisher_jp;

    @NotNull
    private String published_date_jp;

    @NotNull
    private String isbn_jp;

    private String title_tw;
    private String publisher_tw;
    private String published_date_tw;
    private String isbn_tw;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle_jp() {
        return title_jp;
    }

    public void setTitle_jp(String title_jp) {
        this.title_jp = title_jp;
    }

    public String getPublisher_jp() {
        return publisher_jp;
    }

    public void setPublisher_jp(String publisher_jp) {
        this.publisher_jp = publisher_jp;
    }

    public String getPublished_date_jp() {
        return published_date_jp;
    }

    public void setPublished_date_jp(String published_date_jp) {
        this.published_date_jp = published_date_jp;
    }

    public String getIsbn_jp() {
        return isbn_jp;
    }

    public void setIsbn_jp(String isbn_jp) {
        this.isbn_jp = isbn_jp;
    }

    public String getTitle_tw() {
        return title_tw;
    }

    public void setTitle_tw(String title_tw) {
        this.title_tw = title_tw;
    }

    public String getPublisher_tw() {
        return publisher_tw;
    }

    public void setPublisher_tw(String publisher_tw) {
        this.publisher_tw = publisher_tw;
    }

    public String getPublished_date_tw() {
        return published_date_tw;
    }

    public void setPublished_date_tw(String published_date_tw) {
        this.published_date_tw = published_date_tw;
    }

    public String getIsbn_tw() {
        return isbn_tw;
    }

    public void setIsbn_tw(String isbn_tw) {
        this.isbn_tw = isbn_tw;
    }
}