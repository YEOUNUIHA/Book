package com.test.book.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Book {
    private String isbn;
    private String title;
    private byte[] image;
    private String description;
    private String writer;
    private String publisher;
    private String publicationdate;
    private String price;
    private String saleprice;
}
