package com.aivle.bookapp.dto.book.request;

public record BookUpdateRequest(
        String title,
        String author,
        String content,
        Long genreId,
        String coverImageUrl
) {}
