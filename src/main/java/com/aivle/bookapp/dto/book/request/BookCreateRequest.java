package com.aivle.bookapp.dto.book.request;

import jakarta.validation.constraints.NotBlank;

public record BookCreateRequest(
        @NotBlank String title,
        @NotBlank String author,
        @NotBlank String content,
        Long genreId,
        String genre,
        String coverImageUrl
) {}
