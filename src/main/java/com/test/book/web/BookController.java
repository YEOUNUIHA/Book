package com.test.book.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/book")
@RequiredArgsConstructor
public class BookController {

    @GetMapping("/bb")
    public void getBooks(){

    }

    @GetMapping("/{isbn}")
    public void getBook(){

    }

    @GetMapping("/history")
    public void getHistory() {
    }

    @GetMapping("/top10")
    public void getTop10(){

    }
}
