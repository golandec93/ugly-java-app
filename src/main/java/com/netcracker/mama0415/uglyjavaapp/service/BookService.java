package com.netcracker.mama0415.uglyjavaapp.service;

import com.netcracker.mama0415.uglyjavaapp.adapters.JDBCAdapter;
import com.netcracker.mama0415.uglyjavaapp.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class BookService {

    @Autowired private JDBCAdapter jdbcAdapter;

    public Collection<Book> getBooks() {
        final Connection conn = jdbcAdapter.getConnection();
        try(Statement stmnt = conn.createStatement()){
            ResultSet resultSet = stmnt.executeQuery("select * from books");
            Collection<Book> books = new ArrayList<>();
            while (resultSet.next()){
                Book book = new Book();
                book.setName(resultSet.getString("name"));
                book.setDescription(resultSet.getString("description"));
                book.setAuthor(resultSet.getString("author"));
                book.setPageCount(resultSet.getInt("page_count"));
                book.setIsbn13(resultSet.getString("isbn13"));
                book.setIsbn10(resultSet.getString("isbn10"));
                book.setOcls(resultSet.getString("ocls"));
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Book getBook(String bookId) {
        return null;
    }
}
