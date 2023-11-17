package umc.study.web.dto;

import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class RegionStoreDTO{
        Long regionId;
        String name;
        String address;
        Float score;
    }
}
