package com.aivle.bookapp.controller;


import com.aivle.bookapp.dto.book.request.BookCreateRequest;
import com.aivle.bookapp.dto.book.response.BookDetailResponse;
import com.aivle.bookapp.dto.book.response.BookResponse;
import com.aivle.bookapp.dto.book.request.BookUpdateRequest;
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
    public List<BookResponse> bookList() {
        return bookService.getBookList().stream()
                .map(BookResponse::from).toList();
    }

    // 상세 조회: GET /books/{id}
    @GetMapping("/{id}")
    public BookDetailResponse bookDetail(@PathVariable Long id) {
        return BookDetailResponse.from(bookService.getBookDetail(id));
    }

    // 도서 등록: POST /books
    @PostMapping
    public ResponseEntity<BookDetailResponse> bookCreate(@Valid @RequestBody BookCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BookDetailResponse.from(bookService.create(request)));
    }

    // 도서 수정: PATCH /books/{id}
    @PatchMapping("/{id}")
    public BookDetailResponse bookUpdate(@PathVariable Long id, @RequestBody BookUpdateRequest request) {
        return BookDetailResponse.from(bookService.update(id, request));
    }

    // 도서 삭제: DELETE /books/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> bookDelete(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    // 키워드 검색: GET /books/search?q=
    @GetMapping("/search")
    public List<BookResponse> searchBooks(@RequestParam(required = false) String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return bookList();
        }
        return bookService.searchBooks(keyword).stream()
                .map(BookResponse::from)
                .toList();
    }

    // 조회수 증가: PATCH /books/{id}/views
    @PatchMapping("/{id}/views")
    public BookDetailResponse increaseViewCount(@PathVariable Long id) {
        return BookDetailResponse.from(bookService.increaseViewCount(id));
    }

    // 도서 좋아요 증가
    @PatchMapping({"/{id}/likes", "/{id}/like"})
    public BookDetailResponse increaseLikeCount(@PathVariable Long id) {
        return BookDetailResponse.from(bookService.increaseLikeCount(id));
    }

}
