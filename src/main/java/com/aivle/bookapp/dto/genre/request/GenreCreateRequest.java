package com.aivle.bookapp.dto.genre.request;

import jakarta.validation.constraints.NotBlank;

public record GenreCreateRequest(
        @NotBlank String name
) { }
