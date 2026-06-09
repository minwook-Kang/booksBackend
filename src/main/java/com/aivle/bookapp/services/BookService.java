package com.aivle.bookapp.services;

import com.aivle.bookapp.domain.Book;
import com.aivle.bookapp.global.exception.book.BookNotFoundException;
import com.aivle.bookapp.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    public Book getBookDetail(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
    }
}