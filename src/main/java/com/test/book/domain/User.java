package com.test.book.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 20, nullable = false, unique = true)
    private String userid;
    @Column(length = 40, nullable = false)
    private String password;

}
