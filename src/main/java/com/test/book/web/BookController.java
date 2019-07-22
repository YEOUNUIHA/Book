package com.test.book.web;

import com.test.book.dto.BookDto;
import com.test.book.svc.BookService;
import com.test.book.vo.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/book")
public class BookController {

    private final BookService bookService;

    @GetMapping("")
    public List<Book> searchBooks(BookDto.searchBooksReq searchBooksReq){
        return bookService.searchBooks(searchBooksReq);
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
