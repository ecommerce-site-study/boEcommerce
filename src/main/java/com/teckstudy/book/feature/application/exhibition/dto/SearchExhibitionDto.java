package com.teckstudy.book.feature.application.exhibition.dto;

import com.teckstudy.book.feature.domain.base.types.YesNoStatus;
import com.teckstudy.book.feature.domain.exhibition.ContentsType;
import com.teckstudy.book.feature.domain.exhibition.Exhibition;
import com.teckstudy.book.feature.domain.exhibition.types.ExhibitionType;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

@Getter
@Builder
public class SearchExhibitionDto {

    private Long exhibitionId;
    private YesNoStatus useYn;
    private String name;
    private ExhibitionType exhibitionType;
    private YesNoStatus dateYn;
    private String image;
    private String description;
    private String url;
    private String exhibitionStart;
    private String exhibitionEnd;
    private List<ContentsType> contentsList;
    private int bundleContentCnt;

    public SearchExhibitionDto(Long exhibitionId, YesNoStatus useYn, String name, ExhibitionType exhibitionType,
                               YesNoStatus dateYn, String image, String description, String url,
                               String exhibitionStart, String exhibitionEnd, List<ContentsType> contentsList, int bundleContentCnt) {
        this.exhibitionId = exhibitionId;
        this.useYn = useYn;
        this.name = name;
        this.exhibitionType = exhibitionType;
        this.dateYn = dateYn;
        this.image = image;
        this.description = description;
        this.url = url;
        this.exhibitionStart = exhibitionStart;
        this.exhibitionEnd = exhibitionEnd;
        this.contentsList = contentsList;
        this.bundleContentCnt = bundleContentCnt;
    }

    public Exhibition toEntity() {
        return Exhibition.ofNew(exhibitionId, useYn, name, exhibitionType, dateYn, image, description,
                url, exhibitionStart, exhibitionEnd, contentsList, bundleContentCnt);
    }

    public ContentsType toContentsEntity(ContentsType contentsTypes, Exhibition exhibition) {
        return ContentsType.ofNew(contentsTypes, exhibition);
    }

    public Optional<ContentsType> findContentsTypeById(Long contentsId) {
        return this.contentsList
                .stream()
                .filter(contentsType -> contentsType.getContentId() == contentsId)
                .findAny();
    }
}