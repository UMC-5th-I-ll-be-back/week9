package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository storeRepository;
    @Override
    public List<Store> getStoreList(){
        return storeRepository.findAll();
    }

    @Override
    public List<Review> getStoreReviewList(Long id){
        Optional<Store> store = storeRepository.findById(id);
        List<Review> reviewList = store.get().getReviewList();
        return reviewList;
    }
    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }
}
