package com.netcracker.mama0415.uglyjavaapp.service;

import com.netcracker.mama0415.uglyjavaapp.model.Book;
import com.netcracker.mama0415.uglyjavaapp.model.BookDTO;

public class BookTransportConverter {
    public BookDTO convert(Book books) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setIsbn13(books.getIsbn13());
        bookDTO.setName(books.getName());
        bookDTO.setDescription(books.getDescription());
        bookDTO.setAuthor(books.getAuthor());
        bookDTO.setPageCount(books.getPageCount());
        return bookDTO;
    }
}
