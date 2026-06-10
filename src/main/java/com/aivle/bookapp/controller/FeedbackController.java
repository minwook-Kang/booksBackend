package com.aivle.bookapp.controller;

import com.aivle.bookapp.dto.feedback.FeedbackCreateRequest;
import com.aivle.bookapp.dto.feedback.FeedbackResponse;
import com.aivle.bookapp.dto.feedback.FeedbackUpdateRequest;
import com.aivle.bookapp.services.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    // 피드백 조회
    @GetMapping("/reviews/{reviewId}/feedback")
    public FeedbackResponse getFeedback(@PathVariable Long reviewId) {
        return feedbackService.getFeedback(reviewId);
    }

    // 피드백 등록
    @PostMapping("/reviews/{reviewId}/feedback")
    public FeedbackResponse createFeedback(
            @PathVariable Long reviewId,
            @RequestBody FeedbackCreateRequest request
    ) {
        return feedbackService.createFeedback(reviewId, request);
    }

    // 피드백 수정
    @PatchMapping("/feedbacks/{feedbackId}")
    public FeedbackResponse updateFeedback(
            @PathVariable Long feedbackId,
            @RequestBody FeedbackUpdateRequest request
    ) {
        return feedbackService.updateFeedback(feedbackId, request);
    }

    // 피드백 삭제
    @DeleteMapping("/feedbacks/{feedbackId}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long feedbackId) {
        feedbackService.deleteFeedback(feedbackId);
        return ResponseEntity.noContent().build();
    }
}