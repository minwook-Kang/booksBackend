package com.aivle.bookapp.controller;


import com.aivle.bookapp.domain.Book;
import com.aivle.bookapp.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    // 도서 키워드 검색 ( 키워드 없을 시 전체 조회 )
    @GetMapping
    public List<Book> getBooks(@RequestParam(required = false) String q) {
        if (q == null || q.trim().isEmpty()) {
            return bookService.getBookList();
        }
        return bookService.searchBooks(q);
    }

    // 도서 조회하기
    @PatchMapping("/{id}/views")
    public Book increaseViewCount(@PathVariable Long id) {
        return bookService.increaseViewCount(id);
    }

}
