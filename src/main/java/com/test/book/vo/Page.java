package com.test.book.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Page<T> {
    private List<T> documents;
    private PageMeta meta;
}
