package com.teckstudy.book.ui.exhibition;

import com.teckstudy.book.domain.exhibition.types.ContentsType;
import com.teckstudy.book.domain.exhibition.Exhibition;
import com.teckstudy.book.domain.exhibition.types.ExhibitionType;
import com.teckstudy.book.domain.base.types.YesNoStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
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

    public Exhibition fromExhibitionEntity() {

        return Exhibition.builder()
                .use_yn(use_yn)
                .name(name)
                .exhibitionType(exhibitionType)
                .date_yn(date_yn)
                .image(image)
                .description(description)
                .url(url)
                .exhibition_start(exhibition_start)
                .exhibition_end(exhibition_end)
                .bundleContentCnt(bundleContentCnt)
                .build();
    }



    public ContentsType toContentsEntity(ContentsType contentsTypes, Exhibition exhibition) {

        return ContentsType.builder()
                .exhibition(exhibition)
                .contentEnum(contentsTypes.getContentEnum())
                .contentCnt(contentsTypes.getContentCnt())
                .build();
    }
}