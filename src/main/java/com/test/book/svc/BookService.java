package com.test.book.svc;

import com.test.book.config.aop.SearchHistory;
import com.test.book.dto.BookDto;
import com.test.book.vo.Book;
import com.test.book.vo.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class BookService {

    private RestTemplate restTemplate;

    private final String URL = "dapi.kakao.com/v3/search/book";

    private final String TOKEN = "KakaoAK 63675067c8b2500a7765b4fb247aab1b";

    private HttpEntity<String> httpEntity;

    public BookService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
        //restTemplateBuilder.basicAuthentication(username, password).build();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("Authorization",TOKEN);
        this.httpEntity = new HttpEntity<>(httpHeaders);
    }

    @SearchHistory
    public Page<Book> searchBooks(BookDto.searchBooksReq searchBooksReq){
        log.debug("aaaaaaaaaaaaaaa");
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https").host(URL)
                .queryParam("query",searchBooksReq.getQuery())
                .queryParam("target",searchBooksReq.getTarget())
                .queryParam("sort",searchBooksReq.getSort())
                .queryParam("size",searchBooksReq.getSize())
                .queryParam("page",searchBooksReq.getPage())
                .build();

        ResponseEntity<Page> bookResponseEntity = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, httpEntity, Page.class);
        return (Page<Book>) bookResponseEntity.getBody();
    }
}
