package com.irdaislakhuafa.springbootgraphql.controllers;

import com.irdaislakhuafa.springbootgraphql.models.entities.Book;
import com.irdaislakhuafa.springbootgraphql.models.utils.book.NewBook;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @MutationMapping()
    public Book saveBook(@Argument NewBook newBook) {
        return new Book(1L, newBook.getName(), newBook.getPageCount(), newBook.getAuthorId());
    }
}
