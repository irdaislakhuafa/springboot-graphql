package com.irdaislakhuafa.springbootgraphql.models.repositories;

import com.irdaislakhuafa.springbootgraphql.models.entities.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReposiory extends JpaRepository<Book, Long> {

}
