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
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final ReviewRepository reviewRepository;

    // 피드백 조회
    public List<Feedback> getFeedbackList(Long reviewId) {
        return feedbackRepository.findByReviewId(reviewId);
    }

    // 피드백 등록
    public Feedback createFeedback(Long reviewId, Feedback feedback) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new BusinessException(ErrorCode.REVIEW_NOT_FOUND));

        feedback.setReview(review);
        feedback.setCreatedAt(LocalDateTime.now());
        feedback.setUpdatedAt(LocalDateTime.now());

        return feedbackRepository.save(feedback);
    }

    // 피드백 수정
    public Feedback updateFeedback(Long feedbackId, Feedback request) {
        Feedback feedback = feedbackRepository.findById(feedbackId).orElseThrow(() -> new BusinessException(ErrorCode.FEEDBACK_NOT_FOUND));

        if (request.getContent() != null) {
            feedback.setContent(request.getContent());
        }

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