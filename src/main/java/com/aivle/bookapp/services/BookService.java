package com.aivle.bookapp.services;

import com.aivle.bookapp.domain.Book;
import com.aivle.bookapp.domain.Genre;
import com.aivle.bookapp.dto.book.request.BookCreateRequest;
import com.aivle.bookapp.dto.book.request.BookUpdateRequest;
import com.aivle.bookapp.global.exception.book.BookNotFoundException;
import com.aivle.bookapp.global.exception.genre.GenreNotFoundException;
import com.aivle.bookapp.repository.BookRepository;
import com.aivle.bookapp.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;

    @Transactional
    public Book create(BookCreateRequest req) {
        Book book = new Book();
        book.setTitle(req.title());
        book.setAuthor(req.author());
        book.setContent(req.content());
        book.setCoverImageUrl(req.coverImageUrl());
        book.setGenre(findGenre(req.genreId()));
        return bookRepository.save(book);
    }

    @Transactional
    public Book update(Long id, BookUpdateRequest req) {
        Book existing = getBookDetail(id);
        if (req.title() != null) {
            existing.setTitle(req.title());
        }
        if (req.author() != null) {
            existing.setAuthor(req.author());
        }
        if (req.content() != null) {
            existing.setContent(req.content());
        }
        if (req.coverImageUrl() != null) {
            existing.setCoverImageUrl(req.coverImageUrl());
        }
        if (req.genreId() != null) {
            existing.setGenre(findGenre(req.genreId()));
        }
        return existing;
    }

    @Transactional
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException();
        }
        bookRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Book getBookDetail(Long id) {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    @Transactional(readOnly = true)
    public List<Book> searchBooks(String keyword) {
        String k = keyword.trim();
        return bookRepository
                .findByTitleContainingOrAuthorContainingOrContentContaining(k, k, k);
    }

    @Transactional
    public Book increaseViewCount(Long id) {
        Book book = getBookDetail(id);
        if (book.getViews() == null) {
            book.setViews(0);
        }
        book.setViews(book.getViews() + 1);
        return book;
    }

    @Transactional
    public Book increaseLikeCount(Long id) {
        Book book = getBookDetail(id);
        if (book.getLikes() == null) {
            book.setLikes(0);
        }
        book.setLikes(book.getLikes() + 1);
        return book;
    }

    @Transactional(readOnly = true)
    public List<Book> getBooksByGenre(Long genreId) {
        return bookRepository.findByGenreId(genreId);
    }

    private Genre findGenre(Long genreId) {
        return genreRepository.findById(genreId)
                .orElseThrow(GenreNotFoundException::new);
    }
}
