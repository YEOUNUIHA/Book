package com.test.book.svc;

import com.test.book.dto.BookDto;
import com.test.book.vo.Book;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service
public class BookService {

    private RestTemplate restTemplate;

    private final String URL = "dapi.kakao.com/v3/search/book";

    private final String TOKEN = "KakaoAK ";

    private HttpEntity<String> httpEntity;

    public BookService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
        //restTemplateBuilder.basicAuthentication(username, password).build();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("Authorization",TOKEN);
        this.httpEntity = new HttpEntity<>(httpHeaders);
    }

    public List<Book> searchBooks(BookDto.searchBooksReq searchBooksReq){
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https").host(URL)
                .queryParam("target",searchBooksReq.getTarget())
                .queryParam("query",searchBooksReq.getQuery())
                .queryParam("sort",searchBooksReq.getSort())
                .queryParam("size",searchBooksReq.getSize())
                .queryParam("page",searchBooksReq.getPage())
                .build();

        ResponseEntity<Book[]> bookResponseEntity = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, httpEntity, Book[].class);
        return Arrays.asList(bookResponseEntity.getBody());
    }
}
