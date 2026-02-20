package com.ken.blcomiclibrary.dao;

public class BookQueryParams {
    private String publisher_jp;
    private String publisher_tw;
    private String search;
    private String order;
    private String sort;
    private Integer limit;
    private Integer offset;
    private Integer total;

    public String getPublisher_jp() {
        return publisher_jp;
    }

    public void setPublisher_jp(String publisher_jp) {
        this.publisher_jp = publisher_jp;
    }

    public String getPublisher_tw() {
        return publisher_tw;
    }

    public void setPublisher_tw(String publisher_tw) {
        this.publisher_tw = publisher_tw;
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

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
