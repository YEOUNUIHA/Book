package com.test.book.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

public class BookDto {

    @Getter
    @Setter
    public static class searchBooksReq{
        private String target;
        @NotNull
        private String query;
        @Range(min=1,max = 100)
        private int page;
        @Range(min=1,max = 50)
        private int size;
        private String sort;
    }
}
