package com.test.book.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


public class UserDto {

    @Getter @Setter
    @Builder
    public static class loginRes {
        private String msg;
        private boolean result;
    }

    public static class postUserRes {

    }
}
