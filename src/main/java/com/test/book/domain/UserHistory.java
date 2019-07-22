package com.test.book.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class UserHistory {
    private String query;
    private String user;
    private String date;
}
