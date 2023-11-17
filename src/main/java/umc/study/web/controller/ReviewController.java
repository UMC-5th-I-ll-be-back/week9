package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.domain.Review;
import umc.study.service.ReviewService.ReviewService;
import umc.study.web.dto.review.ReviewRequestDto;

import java.util.List;

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

    @GetMapping()
    public ResponseEntity<List<Review>> getReviewList() {
        List<Review> reviewList = reviewService.getReviewList();
        return new ResponseEntity<>(reviewList,HttpStatus.FOUND);
    }
}
