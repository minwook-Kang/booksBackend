package com.aivle.bookapp.dto.book.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookCreateRequest(
        @NotBlank String title,
        @NotBlank String author,
        @NotBlank String content,
        @NotBlank String genre,
        String coverImageUrl
) {}
