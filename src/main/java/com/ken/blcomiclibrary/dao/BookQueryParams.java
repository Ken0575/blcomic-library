package com.ken.blcomiclibrary.dao;

public class BookQueryParams {
    private String Publisher_jp;
    private String search;
    private String order;
    private String sort;

    public String getPublisher_jp() {
        return Publisher_jp;
    }

    public void setPublisher_jp(String publisher_jp) {
        Publisher_jp = publisher_jp;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
