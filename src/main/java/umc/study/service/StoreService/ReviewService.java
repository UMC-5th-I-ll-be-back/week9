package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.review.ReviewRequestDto;
import umc.study.web.dto.store.StoreRequestDto;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private ReviewRepository reviewRepository;
    private StoreRepository storeRepository;

    public Review addReview(ReviewRequestDto requestDto){

        Review review = Review.toEntity(requestDto);
        review.setStore(storeRepository.findByName(requestDto.getStoreName()));

        return reviewRepository.save(review);
    }
}
