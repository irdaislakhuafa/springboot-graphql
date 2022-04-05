package com.irdaislakhuafa.springbootgraphql.models.dto.book;

import java.util.List;

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
    private List<Long> authorsId;
}
