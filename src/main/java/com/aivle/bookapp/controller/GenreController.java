package com.aivle.bookapp.controller;

import com.aivle.bookapp.domain.Genre;
import com.aivle.bookapp.dto.book.response.BookResponse;
import com.aivle.bookapp.dto.genre.request.GenreCreateRequest;
import com.aivle.bookapp.services.BookService;
import com.aivle.bookapp.services.GenreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;
    private final BookService bookService;

    // 장르 추가
    @PostMapping
    public ResponseEntity<Genre> addGenre(@Valid @RequestBody GenreCreateRequest req) {
        Genre genre = genreService.addGenre(req.name());
        return ResponseEntity.status(HttpStatus.CREATED).body(genre);
    }

    // 장르 목록 조회
    @GetMapping
    public ResponseEntity<List<Genre>> getGenres() {
        return ResponseEntity.ok(genreService.getGenres());
    }

    // 장르 별 도서 조회
    @GetMapping("/{genreId}/books")
    public ResponseEntity<List<BookResponse>> getBooksByGenre(@PathVariable Long genreId) {
        List<BookResponse> books = bookService.getBooksByGenre(genreId).stream()
                .map(BookResponse::from)
                .toList();
        return ResponseEntity.ok(books);
    }
}
