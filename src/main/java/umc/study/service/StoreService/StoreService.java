package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Store;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.store.StoreRequestDto;

@RequiredArgsConstructor
@Service
public class StoreService {
    private StoreRepository storeRepository;

    public Store addStore(StoreRequestDto requestDto){
        return storeRepository.save(Store.toEntity(requestDto));
    }
}
