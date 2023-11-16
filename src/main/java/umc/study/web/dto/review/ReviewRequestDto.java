package umc.study.web.dto.review;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import umc.study.domain.ReviewImage;

import java.util.List;
@Getter
@Setter
@RequiredArgsConstructor
public class ReviewRequestDto {
    private String title;
    private Float score;
    private String storeName;
    private List<ReviewImage> reviewImageList;
}
