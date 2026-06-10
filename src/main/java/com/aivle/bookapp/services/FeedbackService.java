package com.aivle.bookapp.services;

import com.aivle.bookapp.domain.Feedback;
import com.aivle.bookapp.domain.Review;
import com.aivle.bookapp.global.exception.BusinessException;
import com.aivle.bookapp.global.exception.ErrorCode;
import com.aivle.bookapp.repository.FeedbackRepository;
import com.aivle.bookapp.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final ReviewRepository reviewRepository;

    // 피드백 조회
    public Feedback getFeedback(Long reviewId) {
        return feedbackRepository.findByReviewId(reviewId).orElseThrow(() -> new BusinessException(ErrorCode.FEEDBACK_NOT_FOUND));
    }

    // 피드백 등록
    public Feedback createFeedback(Long reviewId, Feedback feedback) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new BusinessException(ErrorCode.REVIEW_NOT_FOUND));

        if (feedbackRepository.existsByReviewId(reviewId)) {
            throw new BusinessException(ErrorCode.FEEDBACK_ALREADY_EXISTS);
        }

        feedback.setReview(review);
        feedback.setCreatedAt(LocalDateTime.now());
        feedback.setUpdatedAt(LocalDateTime.now());

        return feedbackRepository.save(feedback);
    }

    // 피드백 수정
    public Feedback updateFeedback(Long feedbackId, Feedback request) {
        Feedback feedback = feedbackRepository.findById(feedbackId).orElseThrow(() -> new BusinessException(ErrorCode.FEEDBACK_NOT_FOUND));

        if (request.getContent() == null || request.getContent().isBlank()) {
            throw new BusinessException(ErrorCode.INVALID_INPUT_VALUE);
        }

        feedback.setContent(request.getContent());
        feedback.setUpdatedAt(LocalDateTime.now());

        return feedbackRepository.save(feedback);
    }

    // 피드백 삭제
    public void deleteFeedback(Long feedbackId) {
        if (!feedbackRepository.existsById(feedbackId)) {
            throw new BusinessException(ErrorCode.FEEDBACK_NOT_FOUND);
        }

        feedbackRepository.deleteById(feedbackId);
    }
}