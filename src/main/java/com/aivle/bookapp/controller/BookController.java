package com.aivle.bookapp.controller;


import com.aivle.bookapp.domain.Book;
import com.aivle.bookapp.services.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // 도서 삭제 DELETE /books/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> BookDelete(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();

    }

    // 도서 등록 POST /books
    @PostMapping
    public ResponseEntity<Book> BookCreate(@Valid @RequestBody Book book){
        Book saved = bookService.create(book);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // 도서 수정 POST /books/{id}
    @PatchMapping("/{id}")
    public Book BookUpdate(@PathVariable Long id, @RequestBody Book book){
        return bookService.update(id, book);
    }
  
    // 도서 키워드 검색 GET /books q?=
    @GetMapping("/search")
    public List<Book> getBooks(@RequestParam(required = false) String q) {
        if (q == null || q.trim().isEmpty()) {
            return bookService.getBookList();
        }
        return bookService.searchBooks(q);
    }

    // 도서 조회하기 Patch
    @PatchMapping("/{id}/views")
    public Book increaseViewCount(@PathVariable Long id) {
        return bookService.increaseViewCount(id);
    }

}
