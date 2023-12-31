package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.RegionHandler;
import umc.study.converter.StoreConverter;
import umc.study.domain.Mission;
import umc.study.domain.Region;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MissionRepository;
import umc.study.repository.RegionRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.store.StoreRequestDTO;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public Store addStore(StoreRequestDTO.RegionStoreDTO request){
        Region region = regionRepository.findById(request.getRegionId()).orElseThrow(()->new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
        Store newStore = StoreConverter.toStore(request, region);

        return storeRepository.save(newStore);
    }

    @Override
    public Mission createmission(Long storeId, StoreRequestDTO.MissionDTO request) {

        Mission mission = StoreConverter.toMission(request);

        mission.setStore(storeRepository.findById(storeId).get());

        return missionRepository.save(mission);
    }

}
