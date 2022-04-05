package com.irdaislakhuafa.springbootgraphql.controllers;

import java.util.List;
import java.util.Optional;

import com.irdaislakhuafa.springbootgraphql.models.dto.book.NewBook;
import com.irdaislakhuafa.springbootgraphql.models.entities.Book;
import com.irdaislakhuafa.springbootgraphql.services.BookService;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @MutationMapping
    public Optional<Book> saveBook(@Argument NewBook newBook) {
        var savedData = bookService.save(bookService.mapToEntity(newBook));
        return savedData;
    }

    @QueryMapping
    public Optional<Book> getBookById(@Argument Long id) {
        var data = bookService.findById(id);
        return data;
    }

    @MutationMapping
    public Optional<Book> updateBook(@Argument Long id, @Argument NewBook newData) {
        var book = bookService.mapToEntity(newData);
        book.setId(id);

        var updatedData = bookService.save(book);
        return updatedData;
    }

    @QueryMapping
    public List<Book> getBooks() {
        return bookService.findAll();
    }

    @MutationMapping
    public Optional<Book> deleteBookById(@Argument Long id) {
        var deletedData = bookService.findById(id);
        bookService.deleteById(id);

        return deletedData;
    }
}
