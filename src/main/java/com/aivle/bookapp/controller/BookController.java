package com.aivle.bookapp.controller;

import com.aivle.bookapp.domain.Book;
import com.aivle.bookapp.services.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> BookDelete(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();

    }

    @PostMapping("/books")
    public ResponseEntity<Book> BookCreate(@Valid @RequestBody Book book){
        Book saved = bookService.create(book);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PatchMapping("/books/{id}")
    public Book BookUpdate(@PathVariable Long id, @RequestBody Book book){
        return bookService.update(id, book);
    }
}
