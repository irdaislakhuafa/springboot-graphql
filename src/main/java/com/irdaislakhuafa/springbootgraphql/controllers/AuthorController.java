package com.irdaislakhuafa.springbootgraphql.controllers;

import java.util.List;
import java.util.Optional;

import com.irdaislakhuafa.springbootgraphql.models.dto.author.NewAuthor;
import com.irdaislakhuafa.springbootgraphql.models.entities.Author;
import com.irdaislakhuafa.springbootgraphql.services.AuthorService;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @QueryMapping(name = "getAuthors")
    public List<Author> getAuthors() {
        return authorService.findAll();
    }

    @MutationMapping
    public Author saveAuthor(@Argument NewAuthor newAuthor) {
        var savedData = authorService.save(authorService.mapToEntity(newAuthor));
        return savedData.get();
    }

    @MutationMapping(name = "updateAuthor")
    public Optional<Author> updateAuthor(@Argument Long id, @Argument NewAuthor newData) {
        var author = authorService.mapToEntity(newData);
        author.setId(id);

        var updatedData = authorService.update(author);
        return updatedData;
    }

    @MutationMapping
    public Optional<Author> deleteById(@Argument Long id) {
        var deletedData = authorService.findById(id);
        authorService.deleteById(id);
        return deletedData;
    }

    @QueryMapping
    public Optional<Author> getAuthorById(@Argument Long id) {
        return authorService.findById(id);
    }

}
