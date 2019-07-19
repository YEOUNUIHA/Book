package com.test.book.web;

import com.test.book.svc.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value="/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public void login(){
        userService.login();
    }

    @PostMapping("")
    public void postUser(){

    }

    @PostMapping("/{userid}")
    public void userIdCheck(){

    }
}
