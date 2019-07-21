package com.test.book.web;

import com.test.book.svc.UserService;
import com.test.book.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value="/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public Boolean login(User user){
        return userService.login(user);
    }

    @PostMapping("")
    public void postUser(User user){
        userService.postUser(user);
    }

    @PostMapping("/{userid}")
    public Boolean userIdCheck(@PathVariable String userid){
        return userService.idCheck(userid);
    }
}
