package com.aivle.bookapp.controller;

import com.aivle.bookapp.domain.Book;
import com.aivle.bookapp.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    // 목록 조회: GET /books
    @GetMapping
    public List<Book> BookList() {
        return bookService.getBookList();
    }

    // 상세 조회: GET /books/{id}
    @GetMapping("/{id}")
    public Book BookDetail(@PathVariable Long id) {
        return bookService.getBookDetail(id);
    }
}