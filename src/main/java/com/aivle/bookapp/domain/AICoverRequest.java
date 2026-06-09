package com.aivle.bookapp.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AICoverRequest {

    @NotBlank(message = "OpenAI API Key를 입력해주세요 .")
    private String apiKey;

    @NotBlank(message = "도서 제목은 입력해주세요 .")
    private String title;

    @NotBlank(message = "작가명은 입력해주세요 .")
    private String author;

    @NotBlank(message = "도서 내용은 입력해주세요.")
    private String content;

    private String quality = "medium";
}