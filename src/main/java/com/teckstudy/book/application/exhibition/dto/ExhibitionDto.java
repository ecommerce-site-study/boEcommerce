package com.teckstudy.book.application.exhibition.dto;

import com.teckstudy.book.domain.base.types.YesNoStatus;
import com.teckstudy.book.domain.exhibition.ContentsType;
import com.teckstudy.book.domain.exhibition.Exhibition;
import com.teckstudy.book.domain.exhibition.types.ExhibitionType;
import com.teckstudy.book.ui.exhibition.dto.ContentsTypeResponseDto;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Data
@NoArgsConstructor
public class ExhibitionDto {

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
    private int bundleContentCnt;
    private List<ContentsDto> contentsList;

    public ExhibitionDto(Long exhibitionId, YesNoStatus useYn, String name, ExhibitionType exhibitionType,
                         YesNoStatus dateYn, String image, String description, String url,
                         String exhibitionStart, String exhibitionEnd, int bundleContentCnt, List<ContentsDto> contentsList) {
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
        this.bundleContentCnt = bundleContentCnt;
        this.contentsList = contentsList;
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
                exhibition.getBundleContentCnt(),
                convert(exhibition.getContentsType())

        );
    }

    private static List<ContentsDto> convert(List<ContentsType> contentsTypes) {
        return contentsTypes.stream()
                .map(ContentsDto::from)
                .collect(Collectors.toList());
    }
}