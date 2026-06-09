package com.aivle.bookapp.repository;

import com.aivle.bookapp.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

public interface BookRepository extends JpaRepository<Book, Long> {
            List<Book> findByTitleContainingOrAuthorContainingOrContentContaining(
            String title,
            String author,
            String contents
    );
}
