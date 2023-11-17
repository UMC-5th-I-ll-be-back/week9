package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.store.StoreRequestDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StoreService {
    private final StoreRepository storeRepository;

    @Transactional
    public void addStore(StoreRequestDto requestDto)
    {
        Store store = storeRepository.findByName(requestDto.getName());
        if(store == null){
            storeRepository.save(Store.toEntity(requestDto));
        }
        else{
            // TODO: 2023/11/17 현재는 중복되는 가게 이름으로 체크 -> 상의 후 로직변경(ex. 가게이름+지역 조합으로 구분하기 or 중복허용하기 or 토큰으로 구분)
            throw new IllegalArgumentException("이미 있는 가게입니다.");
        }
    }

    public List<Store> getStoreList(){
        return storeRepository.findAll();
    }

    public List<Review> getStoreReviewList(Long id){
        Optional<Store> store = storeRepository.findById(id);
        List<Review> reviewList = store.get().getReviewList();
        return reviewList;
    }

}
