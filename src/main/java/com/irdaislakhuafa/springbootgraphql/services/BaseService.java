package com.irdaislakhuafa.springbootgraphql.services;

import java.util.List;
import java.util.Optional;

public interface BaseService<A, B> {
    public Optional<A> save(A entity);

    public Optional<A> findById(Long id);

    public Optional<A> update(A entity);

    public void deleteById(Long id);

    public List<A> findAllById(List<Long> ids);

    public List<A> findAll();

    public A mapToEntity(B entityDto);

    public List<A> mapToEntities(List<B> entitiesDtos);
}
