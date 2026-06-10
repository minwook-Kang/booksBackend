package com.aivle.bookapp.dto.review;

import com.aivle.bookapp.domain.Review;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ReviewResponse {

    private Long reviewId;
    private Long bookId;
    private String content;
    private Double rating;
    private Integer likeCount;
    private LocalDateTime createdAt;

    public static ReviewResponse from(Review review) {
        return ReviewResponse.builder()
                .reviewId(review.getId())
                .bookId(review.getBook().getId())
                .content(review.getContent())
                .rating(review.getRating())
                .likeCount(review.getLikeCount())
                .createdAt(review.getCreatedAt())
                .build();
    }
}