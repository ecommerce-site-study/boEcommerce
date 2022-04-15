package com.teckstudy.book.feature.ui.exhibition.dto;

import com.teckstudy.book.feature.application.exhibition.dto.ContentsDto;
import com.teckstudy.book.feature.domain.exhibition.types.ContentEnum;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ContentsTypeResponseDto {

    private Long exhibitionId;
    private Long contentId;
    private ContentEnum contentEnum;
    private int contentCnt;

    /**
     * 전시카테고리 컨텐츠 조회
     */
    public ContentsTypeResponseDto(Long exhibitionId, Long contentId, ContentEnum contentEnum, int contentCnt) {
        this.exhibitionId = exhibitionId;
        this.contentId = contentId;
        this.contentEnum = contentEnum;
        this.contentCnt = contentCnt;
    }

    public static ContentsTypeResponseDto from(ContentsDto contentsType) {
        return new ContentsTypeResponseDto(
                contentsType.getExhibitionId(),
                contentsType.getContentId(),
                contentsType.getContentEnum(),
                contentsType.getContentCnt()
        );
    }

}