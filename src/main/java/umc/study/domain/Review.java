package umc.study.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.web.dto.review.ReviewRequestDto;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    @JsonIgnore
    private Store store;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewImage> reviewImageList;

    public static Review toEntity(Store store, ReviewRequestDto requestDto){
        return Review.builder()
                .title(requestDto.getTitle())
                .score(requestDto.getScore())
                .reviewImageList(requestDto.getReviewImageList())
                .store(store)
                .build();
    }

}
