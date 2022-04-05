package com.irdaislakhuafa.springbootgraphql.models.utils.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class NewBook {
    private String name;
    private Long pageCount;
    private Long authorId;
}
