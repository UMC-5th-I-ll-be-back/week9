package umc.study.web.dto.store;

import lombok.Getter;
import umc.study.validation.annotation.ExistRegion;

import javax.validation.constraints.NotBlank;

public class StoreRequestDTO {

    @Getter
    public static class RegionStoreDTO{
        @ExistRegion
        Long regionId;
        @NotBlank
        String name;
        @NotBlank
        String address;
        Float score;
    }
}
