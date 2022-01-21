package com.teckstudy.book.ui.exhibition.dto;

import com.teckstudy.book.application.exhibition.dto.SearchExhibitionDto;
import com.teckstudy.book.domain.base.types.YesNoStatus;
import com.teckstudy.book.domain.exhibition.ContentsType;
import com.teckstudy.book.domain.exhibition.types.ExhibitionType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ExhibitionRequestDto {

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

    public SearchExhibitionDto toWrapper() {
        return new SearchExhibitionDto(
            this.exhibitionId,
            this.useYn,
            this.name,
            this.exhibitionType,
            this.dateYn,
            this.image,
            this.description,
            this.url,
            this.exhibitionStart,
            this.exhibitionEnd,
            this.contentsList,
            this.bundleContentCnt
        );
    }

}