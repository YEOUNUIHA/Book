package com.test.book.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(length = 20, nullable = false, unique = true)
    private String userid;
    @NotNull
    @Column(length = 60, nullable = false)
    private String password;

}
