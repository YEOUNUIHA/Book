package com.test.book.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Book {
    private String isbn;
    private String title;
    private String thumbnail;
    private String contents;
    private List<String> authors;
    private String publisher;
    private String datetime;
    private String price;
    private String sale_price;
}
