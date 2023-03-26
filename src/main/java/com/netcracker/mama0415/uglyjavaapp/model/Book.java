package com.netcracker.mama0415.uglyjavaapp.model;

public class Book {
    private String id;
    private String name;
    private String description;
    private String author;
    private int pageCount;
    private String isbn;
    private String ocls;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getOcls() {
        return ocls;
    }

    public void setOcls(String ocls) {
        this.ocls = ocls;
    }
}
