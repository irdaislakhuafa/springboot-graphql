package com.irdaislakhuafa.springbootgraphql.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.irdaislakhuafa.springbootgraphql.models.dto.author.NewAuthor;
import com.irdaislakhuafa.springbootgraphql.models.entities.Author;
import com.irdaislakhuafa.springbootgraphql.models.repositories.AuthorRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorService implements BaseService<Author, NewAuthor> {

    private final AuthorRepository authorRepository;

    @Override
    public Optional<Author> save(Author entity) {
        return Optional.of(authorRepository.save(entity));
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> update(Author entity) {
        return save(entity);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> findAllById(List<Long> ids) {
        return authorRepository.findAllById(ids);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author mapToEntity(NewAuthor entityDto) {
        return Author.builder()
                .firstName(entityDto.getFirstName())
                .lastName(entityDto.getLastName())
                .build();
    }

    @Override
    public List<Author> mapToEntities(List<NewAuthor> entitiesDtos) {
        return entitiesDtos.stream().map((dto) -> mapToEntity(dto)).collect(Collectors.toList());
    }

}
