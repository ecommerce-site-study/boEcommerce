package com.teckstudy.book.ui.exhibition.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.teckstudy.book.domain.exhibition.Exhibition;
import com.teckstudy.book.domain.exhibition.types.ExhibitionType;
import com.teckstudy.book.domain.base.types.YesNoStatus;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ExhibitionResponseDto {

    private Long exhibitionIdn;
    private YesNoStatus useYn;
    private String name;
    private ExhibitionType exhibitionType;
    private YesNoStatus dateYn;
    private String image;
    private String description;
    private String url;
    private String exhibitionStart;
    private String exhibitionEnd;
    private int bundleContentCnt;
    private List<ContentsTypeResponseDto> contentsList;

    /**
     *
     * 전시카테고리 전체 조회
     * @param exhibitionIdn
     * @param useYn
     * @param name
     * @param exhibitionType
     * @param dateYn
     * @param image
     * @param description
     * @param url
     * @param exhibitionStart
     * @param exhibitionEnd
     * @param bundleContentCnt
     */
    @QueryProjection
    public ExhibitionResponseDto(Long exhibitionIdn, YesNoStatus useYn, String name, ExhibitionType exhibitionType, YesNoStatus dateYn, String image, String description, String url, String exhibitionStart, String exhibitionEnd, int bundleContentCnt) {
        this.exhibitionIdn = exhibitionIdn;
        this.useYn = useYn;
        this.name = name;
        this.exhibitionType = exhibitionType;
        this.dateYn = dateYn;
        this.image = image;
        this.description = description;
        this.url = url;
        this.exhibitionStart = exhibitionStart;
        this.exhibitionEnd = exhibitionEnd;
        this.bundleContentCnt = bundleContentCnt;
    }

    /**
     * 전시관리 조회
     * @param exhibition
     */
    public static ExhibitionResponseDto from(Exhibition exhibition) {
        return new ExhibitionResponseDto(
                exhibition.getExhibitionId(),
                exhibition.getUseYn(),
                exhibition.getName(),
                exhibition.getExhibitionType(),
                exhibition.getDateYn(),
                exhibition.getImage(),
                exhibition.getDescription(),
                exhibition.getUrl(),
                exhibition.getExhibitionStart(),
                exhibition.getExhibitionEnd(),
                exhibition.getBundleContentCnt()
        );

    }

}