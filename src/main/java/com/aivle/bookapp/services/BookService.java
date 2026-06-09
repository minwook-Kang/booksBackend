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

    public Book getBookDetail(Long id) {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    public void deleteBook(Long id){
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
        }else{
            throw new BookNotFoundException(id);
        }
    }

    public Book create(Book book){
        return bookRepository.save(book);
    }

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
        if(book.getImageUrl() != null){
            existing.setImageUrl(book.getImageUrl());
        }

        return bookRepository.save(existing);
    }
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    public Book getBookDetail(Long id) {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }
}

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
        Book book = bookRepository.findById(id).orElseThrow(BookNotFoundException::new); // 에러처리 적용

        if (book.getViews() == null) {
            book.setViews(0L);
        }
        book.setViews(book.getViews() + 1);

        return bookRepository.save(book);
    }


}
