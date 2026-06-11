package com.aivle.bookapp.dto.book.response;

import com.aivle.bookapp.domain.Book;

public record BookResponse(
        Long id, String title, String author,
        String genre, Integer views
) {
    public static BookResponse from(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getGenre().getName(),
                book.getViews());
    }
}
