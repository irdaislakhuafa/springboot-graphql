package com.irdaislakhuafa.springbootgraphql.controllers;

import java.util.ArrayList;

import com.irdaislakhuafa.springbootgraphql.models.dto.book.NewBook;
import com.irdaislakhuafa.springbootgraphql.models.entities.Book;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {

    @MutationMapping
    public Book saveBook(@Argument NewBook newBook) {

        return new Book(1L, newBook.getName(), newBook.getPageCount(), new ArrayList<>());
    }
}
