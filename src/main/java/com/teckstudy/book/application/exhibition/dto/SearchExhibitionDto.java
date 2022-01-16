package com.teckstudy.book.application.exhibition.dto;

import com.teckstudy.book.domain.base.types.YesNoStatus;
import com.teckstudy.book.domain.exhibition.ContentsType;
import com.teckstudy.book.domain.exhibition.types.ExhibitionType;

import java.util.List;

public class SearchExhibitionDto {

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

    public SearchExhibitionDto(Long exhibitionIdn, YesNoStatus useYn, String name, ExhibitionType exhibitionType,
                               YesNoStatus dateYn, String image, String description, String url,
                               String exhibitionStart, String exhibitionEnd, List<ContentsType> contentsList, int bundleContentCnt) {
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
}