package umc.study.web.dto.store;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class StoreRequestDto {
    private String address;
    private String name;
    private Float score;
    private String region;
}
