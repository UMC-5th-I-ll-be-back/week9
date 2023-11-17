package umc.study.converter;

import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

public class StoreConverter {
    public static StoreResponseDTO.RegionStoreResultDTO toRegionStoreResultDTO(Store store){
        return StoreResponseDTO.RegionStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }

    public static Store toStore(StoreRequestDTO.RegionStoreDTO request){

        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(request.getScore())
                .build();
    }
}
