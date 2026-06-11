package com.aivle.bookapp.dto.book.response;

import com.aivle.bookapp.domain.Book;
import com.aivle.bookapp.domain.Genre;

import java.time.LocalDateTime;

public record BookDetailResponse(
        Long id, String title, String author, String content,
        Long genreId, String genre, String coverImageUrl,
        Integer views, LocalDateTime createdAt, LocalDateTime updatedAt
) {
    public static BookDetailResponse from(Book book) {
        Genre genre = book.getGenre();
        return new BookDetailResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getContent(),
                genre.getId(),
                genre.getName(),
                book.getCoverImageUrl(),
                book.getViews(),
                book.getCreatedAt(),
                book.getUpdatedAt());
    }
}