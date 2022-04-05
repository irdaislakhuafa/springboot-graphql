package com.irdaislakhuafa.springbootgraphql.controllers;

import java.util.ArrayList;
import java.util.List;

import com.irdaislakhuafa.springbootgraphql.models.Author;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {
    @QueryMapping
    public List<Author> authors() {
        return new ArrayList<>();
    }
}
