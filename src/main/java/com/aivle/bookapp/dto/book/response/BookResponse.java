package com.aivle.bookapp.dto.book.response;

import com.aivle.bookapp.domain.Book;

import java.time.LocalDateTime;

public record BookResponse(
        Long id, String title, String author,
        String genre, String coverImageUrl, Integer views, Integer likes,
        LocalDateTime createdAt, LocalDateTime updatedAt
) {
    public static BookResponse from(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getGenre().getName(),
                book.getCoverImageUrl(),
                book.getViews(),
                book.getLikes(),
                book.getCreatedAt(),
                book.getUpdatedAt());
    }
}
