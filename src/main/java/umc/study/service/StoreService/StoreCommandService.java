package umc.study.service.StoreService;

import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.store.StoreRequestDTO;

import java.util.List;

public interface StoreCommandService {
    Store addStore(StoreRequestDTO.RegionStoreDTO request);

    Mission createmission(Long storeId, StoreRequestDTO.MissionDTO request);

}
