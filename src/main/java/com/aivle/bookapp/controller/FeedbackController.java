package com.aivle.bookapp.controller;

import com.aivle.bookapp.domain.Feedback;
import com.aivle.bookapp.services.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    // 피드백 조회
    @GetMapping("/reviews/{reviewId}/feedback")
    public List<Feedback> getFeedbackList(@PathVariable Long reviewId) {
        return feedbackService.getFeedbackList(reviewId);
    }

    // 피드백 등록
    @PostMapping("/reviews/{reviewId}/feedback")
    public Feedback createFeedback(@PathVariable Long reviewId, @RequestBody Feedback feedback) {
        return feedbackService.createFeedback(reviewId, feedback);
    }

    // 피드백 수정
    @PatchMapping("/feedbacks/{feedbackId}")
    public Feedback updateFeedback(@PathVariable Long feedbackId, @RequestBody Feedback feedback) {
        return feedbackService.updateFeedback(feedbackId, feedback);
    }

    // 피드백 삭제
    @DeleteMapping("/feedbacks/{feedbackId}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long feedbackId) {
        feedbackService.deleteFeedback(feedbackId);
        return ResponseEntity.noContent().build();
    }
}