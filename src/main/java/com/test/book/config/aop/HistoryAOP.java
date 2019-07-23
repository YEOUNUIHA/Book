package com.test.book.config.aop;

import com.test.book.domain.SearchHistory;
import com.test.book.domain.SearchHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class HistoryAOP {

    private final SearchHistoryRepository searchHistoryRepository;

    @Around("@annotation(com.test.book.config.aop.SearchHistory)")
    public Object AfterService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = proceedingJoinPoint.proceed();


        return result;
    }
}
