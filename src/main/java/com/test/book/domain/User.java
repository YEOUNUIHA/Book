package com.test.book.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter @Setter
@Entity
@Builder
public class User {

    @Id
    @Column(length = 30, nullable = false)
    private String userid;

    @Column(length = 50, nullable = false)
    private String password;
}
