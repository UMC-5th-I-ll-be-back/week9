package umc.study.domain;

import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.web.dto.review.ReviewRequestDto;
import umc.study.web.dto.store.StoreRequestDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    public static Store toEntity(StoreRequestDto requestDto){
        return Store.builder()
                .name(requestDto.getName())
                .address(requestDto.getAddress())
                .score(requestDto.getScore())
                .build();
    }
}