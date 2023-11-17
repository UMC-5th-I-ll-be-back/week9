package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.RegionHandler;
import umc.study.converter.StoreConverter;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.repository.RegionRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store addStore(StoreRequestDTO.RegionStoreDTO request){
        Store newStore = StoreConverter.toStore(request);
        Region region = regionRepository.findById(request.getRegionId()).orElseThrow(()->new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        return storeRepository.save(newStore);
    }

}