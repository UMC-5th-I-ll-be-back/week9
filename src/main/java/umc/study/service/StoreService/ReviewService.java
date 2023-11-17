package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.review.ReviewRequestDto;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;

    public Review addReview(ReviewRequestDto requestDto){
        Store store = storeRepository.findByName(requestDto.getStoreName());
        Review review = Review.toEntity(store, requestDto);
        return reviewRepository.save(review);
    }

    public List<Review> getReviewList(){
        return reviewRepository.findAll();
    }
}