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

    // 도서 키워드 검색
    public List<Book> searchBooks(String keyword) {
        String trimmedKeyword = keyword.trim();

        return bookRepository.findByTitleContainingOrAuthorContainingOrContentsContaining(
                trimmedKeyword,
                trimmedKeyword,
                trimmedKeyword
        );
    }

    // 도서 조회수 증가
    public Book increaseViewCount(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);

        if (book.getViews() == null) {
            book.setViews(0L);
        }
        book.setViews(book.getViews() + 1);

        return bookRepository.save(book);
    }


}
