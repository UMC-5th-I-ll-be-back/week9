package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.domain.Review;
import umc.study.service.ReviewService.ReviewService;
import umc.study.web.dto.review.ReviewRequestDto;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;
    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody ReviewRequestDto reviewRequestDto){
        Review savedReview = reviewService.addReview(reviewRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedReview);
    }
}
