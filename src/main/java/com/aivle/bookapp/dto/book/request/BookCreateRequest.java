package com.aivle.bookapp.dto.book.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookCreateRequest(
        @NotBlank String title,
        @NotBlank String author,
        @NotBlank String content,
        @NotNull Long genreId,
        String coverImageUrl
) {}
