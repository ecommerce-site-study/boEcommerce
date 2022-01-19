package com.teckstudy.book.ui.exhibition.dto;

import com.teckstudy.book.application.exhibition.dto.ContentsDto;
import com.teckstudy.book.application.exhibition.dto.ExhibitionDto;
import com.teckstudy.book.domain.base.types.YesNoStatus;
import com.teckstudy.book.domain.exhibition.ContentsType;
import com.teckstudy.book.domain.exhibition.types.ExhibitionType;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter

public class ExhibitionResponseDto {

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
    private List<ContentsTypeResponseDto> contentsList;


    @Builder
    public ExhibitionResponseDto(Long exhibitionId, YesNoStatus useYn, String name,
                                 ExhibitionType exhibitionType, YesNoStatus dateYn, String image,
                                 String description, String url, String exhibitionStart, String exhibitionEnd,
                                 int bundleContentCnt, List<ContentsTypeResponseDto> contentsList) {
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

    /**
     * 전시관리 조회
     * @param exhibition
     */
    public static ExhibitionResponseDto from(ExhibitionDto exhibition) {
        return ExhibitionResponseDto.builder()
                .exhibitionId(exhibition.getExhibitionId())
                .useYn(exhibition.getUseYn())
                .name(exhibition.getName())
                .exhibitionType(exhibition.getExhibitionType())
                .dateYn(exhibition.getDateYn())
                .image(exhibition.getImage())
                .description(exhibition.getDescription())
                .url(exhibition.getUrl())
                .exhibitionStart(exhibition.getExhibitionStart())
                .exhibitionEnd(exhibition.getExhibitionEnd())
                .bundleContentCnt(exhibition.getBundleContentCnt())
                .contentsList(convert(exhibition.getContentsList()))
                .build();
    }

    private static List<ContentsTypeResponseDto> convert(List<ContentsDto> contentsTypes) {
        return contentsTypes.stream()
                .map(ContentsTypeResponseDto::from)
                .collect(Collectors.toList());
    }
}