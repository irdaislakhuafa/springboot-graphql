package com.irdaislakhuafa.springbootgraphql.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.irdaislakhuafa.springbootgraphql.models.dto.book.NewBook;
import com.irdaislakhuafa.springbootgraphql.models.entities.Book;
import com.irdaislakhuafa.springbootgraphql.models.repositories.BookReposiory;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService implements BaseService<Book, NewBook> {

    private final BookReposiory bookReposiory;
    private final AuthorService authorService;

    @Override
    public Optional<Book> save(Book entity) {
        return Optional.of(bookReposiory.save(entity));
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookReposiory.findById(id);
    }

    @Override
    public Optional<Book> update(Book entity) {
        return save(entity);
    }

    @Override
    public void deleteById(Long id) {
        bookReposiory.deleteById(id);
    }

    @Override
    public List<Book> findAllById(List<Long> ids) {
        return bookReposiory.findAllById(ids);
    }

    @Override
    public List<Book> findAll() {
        return bookReposiory.findAll();
    }

    @Override
    public Book mapToEntity(NewBook entityDto) {
        return Book.builder()
                .name(entityDto.getName())
                .pageCount(entityDto.getPageCount())
                .authors(authorService.findAllById(entityDto.getAuthorsId()))
                .build();
    }

    @Override
    public List<Book> mapToEntities(List<NewBook> entitiesDtos) {
        return entitiesDtos.stream().map((dto) -> mapToEntity(dto)).collect(Collectors.toList());
    }

}
