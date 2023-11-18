package umc.study.service.StoreService;

import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Review;
import umc.study.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {
    List<Store> getStoreList();

    @Transactional
    List<Review> getStoreReviewList(Long id);

    Optional<Store> findStore(Long id);
}
