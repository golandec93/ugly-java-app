package com.netcracker.mama0415.uglyjavaapp.web;

import com.netcracker.mama0415.uglyjavaapp.model.BookAvailabilityRecord;
import com.netcracker.mama0415.uglyjavaapp.model.BookDTO;
import com.netcracker.mama0415.uglyjavaapp.service.BookService;
import com.netcracker.mama0415.uglyjavaapp.service.BookTransportConverter;
import com.netcracker.mama0415.uglyjavaapp.service.WarehouseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public Collection<BookDTO> getBooksList() {
        var bookService = new BookService();
        var bookToDtoConverter = new BookTransportConverter();
        var books = bookService.getBooks();
        return books.stream()
                .map(bookToDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @GetMapping("/{bookId}")
    public BookDTO getBook(@PathVariable String bookId) {
        var bookService = new BookService();
        var book = bookService.getBook(bookId);
        return new BookTransportConverter().convert(book);
    }

    @GetMapping("/{bookId}/availability")
    public Collection<BookAvailabilityRecord> getBookAvailability(@PathVariable String bookId) {
        var warehouseService = new WarehouseService();
        var availabilityReport = warehouseService.getAvailabilityReport(bookId);
        return availabilityReport.entrySet().stream()
                .map((entry -> {
                    var record = new BookAvailabilityRecord();
                    record.setAvailable(entry.getValue());
                    record.setWarehouseId(entry.getKey().getId());
                    record.setWarehouseAddress(entry.getKey().getAddress());
                    record.setWarehouseName(entry.getKey().getName());
                    return record;
                })).collect(Collectors.toList());
    }
}
