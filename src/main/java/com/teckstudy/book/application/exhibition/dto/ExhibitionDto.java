package com.teckstudy.book.application.exhibition.dto;

import com.teckstudy.book.domain.base.types.YesNoStatus;
import com.teckstudy.book.domain.exhibition.Exhibition;
import com.teckstudy.book.domain.exhibition.types.ExhibitionType;
import com.teckstudy.book.ui.exhibition.dto.ContentsTypeResponseDto;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Data
@NoArgsConstructor
public class ExhibitionDto {

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

    public ExhibitionDto(Long exhibitionIdn, YesNoStatus useYn, String name, ExhibitionType exhibitionType,
                         YesNoStatus dateYn, String image, String description, String url,
                         String exhibitionStart, String exhibitionEnd, int bundleContentCnt) {
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

    public static ExhibitionDto from(Exhibition exhibition) {
        return new ExhibitionDto(
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