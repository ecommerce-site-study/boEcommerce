package com.teckstudy.book.feature.application.exhibition.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.teckstudy.book.feature.domain.exhibition.ContentsType;
import com.teckstudy.book.feature.domain.exhibition.types.ContentEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ContentsDto {
    private Long exhibitionId;
    private Long contentId;
    private ContentEnum contentEnum;
    private int contentCnt;

    /**
     * 전시카테고리 컨텐츠 조회
     */
    @QueryProjection
    public ContentsDto(Long exhibitionId, Long contentId, ContentEnum contentEnum, int contentCnt) {
        this.exhibitionId = exhibitionId;
        this.contentId = contentId;
        this.contentEnum = contentEnum;
        this.contentCnt = contentCnt;
    }

    public static ContentsDto from(ContentsType contentsType) {
        return new ContentsDto(
                contentsType.getExhibition().getExhibitionId(),
                contentsType.getContentId(),
                contentsType.getContentEnum(),
                contentsType.getContentCnt()
        );
    }
}
