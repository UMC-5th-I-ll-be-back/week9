package umc.study.web.dto.store;

import lombok.Getter;
import umc.study.validation.annotation.ExistRegion;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class StoreRequestDTO {

    @Getter
    public static class StoreDTO{
        private String address;
        @NotNull
        private Float score;
        @NotBlank
        private String name;
    }

    @Getter
    public static class MissionDTO{
        private Integer reward;
        private LocalDate deadline;
        private String missionSpec;
    }

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
