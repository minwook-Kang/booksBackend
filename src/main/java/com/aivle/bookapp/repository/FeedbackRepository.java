package com.aivle.bookapp.repository;

import com.aivle.bookapp.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    Optional<Feedback> findByReviewId(Long reviewId);

    // 리뷰에 피드백 존재여부
    boolean existsByReviewId(Long reviewId);
}