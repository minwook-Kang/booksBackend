package com.aivle.bookapp.repository;

import com.aivle.bookapp.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByReviewId(Long reviewId);
}
