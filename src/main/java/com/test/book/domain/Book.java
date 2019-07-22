package com.test.book.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//@Entity
@Getter @Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column()
    private String isbn;
    @Column()
    private String title;
    @Column()
    private String url;
    @Column()
    private String datetime;
    @Column()
    private String thumbnail;
    @Column()
    private String contents;
    @Column()
    private String[] authors;
    @Column()
    private String publisher;
    @Column()
    private String[] translators;
    @Column()
    private String publicationdate;
    @Column()
    private String price;
    @Column()
    private String sale_price;
    @Column()
    private String status;
}
