package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.web.dto.store.StoreRequestDTO;
import umc.study.web.dto.store.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {
    public static StoreResponseDTO.RegionStoreResultDTO toRegionStoreResultDTO(Store store){
        return StoreResponseDTO.RegionStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }

    public static Store toStore(StoreRequestDTO.RegionStoreDTO request, Region region){

        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(request.getScore())
                .region(region)
                .build();
    }

    public static Mission toMission(StoreRequestDTO.MissionDTO request){
        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .build();
    }

    public static StoreResponseDTO.CreateMissionResultDTO toCreateMissionResultDto(Mission mission){
        return StoreResponseDTO.CreateMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
