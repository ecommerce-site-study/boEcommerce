package com.teckstudy.book.feature.exhibition.ui.request;

import com.teckstudy.book.feature.exhibition.application.dto.ContentsDto;
import com.teckstudy.book.feature.exhibition.application.dto.ExhibitionDto;
import com.teckstudy.book.core.types.YesNoStatus;
import com.teckstudy.book.feature.exhibition.types.ExhibitionType;
import com.teckstudy.book.feature.exhibition.ui.response.ContentsTypeResponse;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ExhibitionResponse {

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
    private List<ContentsTypeResponse> contentsList;


    @Builder
    public ExhibitionResponse(Long exhibitionId, YesNoStatus useYn, String name,
                              ExhibitionType exhibitionType, YesNoStatus dateYn, String image,
                              String description, String url, String exhibitionStart, String exhibitionEnd,
                              int bundleContentCnt, List<ContentsTypeResponse> contentsList) {
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
    public static ExhibitionResponse from(ExhibitionDto exhibition) {
        return ExhibitionResponse.builder()
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

    private static List<ContentsTypeResponse> convert(List<ContentsDto> contentsTypes) {
        return contentsTypes.stream()
                .map(ContentsTypeResponse::from)
                .collect(Collectors.toList());
    }
}