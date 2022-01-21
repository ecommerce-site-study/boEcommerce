package com.teckstudy.book.domain.exhibition;

import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.exhibition.types.ExhibitionType;
import com.teckstudy.book.domain.base.types.YesNoStatus;
import lombok.*;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@SequenceGenerator(
        name = "EXHIBITION_SEQ_GENERATOR",
        sequenceName = "EXHIBITION_SEQ", // 매핑할 데이터베이스 시퀀스 이름
        initialValue = 10000001,
        allocationSize = 1)
@NoArgsConstructor
public class Exhibition extends BaseEntity {

    // 전시코너코드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "EXHIBITION_SEQ_GENERATOR")
    private Long exhibitionId;

    // 전시코너 사용여부
    @Enumerated(EnumType.STRING)
    private YesNoStatus useYn;

    // 전시코너명
    @Column(length = 20)
    private String name;

    // 전시코너 노출유형
    @Enumerated(EnumType.STRING)
    private ExhibitionType exhibitionType;

    // 전시기간 설정
    @Enumerated(EnumType.STRING)
    private YesNoStatus dateYn;

    // 전시코너 이미지
    private String image;

    // 전시코너 설명
    private String description;

    // 전시코너 Html URL
    private String url;

    // 전시기간 시작 날짜
    private String exhibitionStart;

    // 전시기간 종료 날짜
    private String exhibitionEnd;

    // 컨텐츠 타입 묶음컨텐츠 최대 개수
    private int bundleContentCnt;

    // 컨텐츠 유형
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "exhibition", cascade = CascadeType.ALL)
    private List<ContentsType> contentsType;

    public List<ContentsType> getContentsType() {
        return Objects.isNull(contentsType) ? Collections.emptyList() : contentsType;
    }

    private Exhibition(Long exhibitionId, YesNoStatus useYn, String name,
                       ExhibitionType exhibitionType, YesNoStatus dateYn,
                       String image, String description, String url,
                       String exhibitionStart, String exhibitionEnd, List<ContentsType> contentsList,
                       int bundleContentCnt) {

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
        this.contentsType = contentsList;
        this.bundleContentCnt = bundleContentCnt;
    }

    public static Exhibition ofNew(Long exhibitionId, YesNoStatus useYn, String name,
                                   ExhibitionType exhibitionType, YesNoStatus dateYn, String image,
                                   String description, String url, String exhibitionStart, String exhibitionEnd,
                                   List<ContentsType> contentsList, int bundleContentCnt) {
        return new Exhibition(exhibitionId, useYn, name, exhibitionType, dateYn, image, description,
                url, exhibitionStart, exhibitionEnd, contentsList, bundleContentCnt);
    }

}