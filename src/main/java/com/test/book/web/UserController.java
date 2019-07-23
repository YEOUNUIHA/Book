package com.test.book.web;

import com.test.book.dto.UserDto;
import com.test.book.svc.UserService;
import com.test.book.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public UserDto.loginRes login(@Valid @RequestBody User user){
        return userService.login(user);
    }

    @PostMapping("")
    public String postUser(@RequestBody User user){
        String result = userService.postUser(user);
        return result;
    }

    @PostMapping("/{userid}")
    public void userIdCheck(){

    }
}
