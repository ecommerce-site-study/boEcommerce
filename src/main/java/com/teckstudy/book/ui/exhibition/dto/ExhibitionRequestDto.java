package com.teckstudy.book.ui.exhibition.dto;

import com.teckstudy.book.application.exhibition.dto.SearchExhibitionDto;
import com.teckstudy.book.domain.exhibition.ContentsType;
import com.teckstudy.book.domain.exhibition.types.ExhibitionType;
import com.teckstudy.book.domain.base.types.YesNoStatus;

import java.util.List;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data
public class ExhibitionRequestDto {

    private Long exhibition_sn;
    private YesNoStatus use_yn;
    private String name;
    private ExhibitionType exhibitionType;
    private YesNoStatus date_yn;
    private String image;
    private String description;
    private String url;
    private String exhibition_start;
    private String exhibition_end;
    private List<ContentsType> contentsList;
    private int bundleContentCnt;

    public SearchExhibitionDto toWrapper() {

        return new SearchExhibitionDto(
            this.exhibition_sn,
            this.use_yn,
            this.name,
            this.exhibitionType,
            this.date_yn,
            this.image,
            this.description,
            this.url,
            this.exhibition_start,
            this.exhibition_end,
            this.contentsList,
            this.bundleContentCnt
        );
    }

//    public Exhibition fromExhibitionEntity() {
//
//        return Exhibition.builder()
//                .use_yn(use_yn)
//                .name(name)
//                .exhibitionType(exhibitionType)
//                .date_yn(date_yn)
//                .image(image)
//                .description(description)
//                .url(url)
//                .exhibition_start(exhibition_start)
//                .exhibition_end(exhibition_end)
//                .bundleContentCnt(bundleContentCnt)
//                .build();
//    }



//    public ContentsType toContentsEntity(ContentsType contentsTypes, Exhibition exhibition) {
//
//        return ContentsType.builder()
//                .exhibition(exhibition)
//                .contentEnum(contentsTypes.getContentEnum())
//                .contentCnt(contentsTypes.getContentCnt())
//                .build();
//    }
}