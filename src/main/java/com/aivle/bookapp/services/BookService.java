package com.aivle.bookapp.services;


import com.aivle.bookapp.domain.Book;
import com.aivle.bookapp.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
