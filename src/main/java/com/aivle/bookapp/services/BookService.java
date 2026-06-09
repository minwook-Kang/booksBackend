package com.aivle.bookapp.services;

import com.aivle.bookapp.domain.Book;
import com.aivle.bookapp.global.exception.book.BookNotFoundException;
import com.aivle.bookapp.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    // 도서 삭제
    public void deleteBook(Long id){
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
        }else{
            throw new BookNotFoundException();
        }
    }

    // 도서 등록
    public Book create(Book book){
        return bookRepository.save(book);
    }

    // 도서 수정
    public Book update(Long id, Book book){
        Book existing = getBookDetail(id);

        if(book.getTitle() != null){
            existing.setTitle(book.getTitle());
        }
        if(book.getAuthor() != null){
            existing.setAuthor(book.getAuthor());
        }
        if(book.getContent() != null){
            existing.setContent(book.getContent());
        }
        if(book.getGenre() != null){
            existing.setGenre(book.getGenre());
        }
        if(book.getCoverImageUrl() != null){
            existing.setCoverImageUrl(book.getCoverImageUrl());
        }

        return bookRepository.save(existing);
    }

    // 도서 전체 조회
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    // 해당 도서 조회
    public Book getBookDetail(Long id) {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    // 도서 키워드 검색
    public List<Book> searchBooks(String keyword) {
        String trimmedKeyword = keyword.trim();

        return bookRepository.findByTitleContainingOrAuthorContainingOrContentContaining(
                trimmedKeyword,
                trimmedKeyword,
                trimmedKeyword
        );
    }

    // 도서 조회수 증가
    public Book increaseViewCount(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(BookNotFoundException::new); // 에러처리 적용

        if (book.getViews() == null) {
            book.setViews(0);
        }
        book.setViews(book.getViews() + 1);

        return bookRepository.save(book);
    }

}
