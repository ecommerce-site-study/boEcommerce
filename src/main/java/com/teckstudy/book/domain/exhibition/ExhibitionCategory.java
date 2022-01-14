package com.teckstudy.book.domain.exhibition;

import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.exhibition.types.ExhibitionType;
import com.teckstudy.book.domain.base.types.YesNoStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@SequenceGenerator(
        name = "CATEGORY_SEQ_GENERATOR",
        sequenceName = "CATEGORY_SEQ", // 매핑할 데이터베이스 시퀀스 이름
        initialValue = 10000001,
        allocationSize = 1)
public class ExhibitionCategory extends BaseEntity {

    // 전시코너코드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "CATEGORY_SEQ_GENERATOR")
    private Long categoryId;

    // 전시코너명
    private String name;

    // 메뉴노출여부
    @Enumerated(EnumType.STRING)
    private YesNoStatus menuShowYn;

    // 메뉴사용여부
    @Enumerated(EnumType.STRING)
    private YesNoStatus menuUseYn;

    // 메뉴노출유형
    @Enumerated(EnumType.STRING)
    private ExhibitionType menuType;

    // 메뉴노출 텍스트
    private String menuText;

    // 메뉴노출 이미지
    private String menuImage;

    // 타이틀노출유형
    @Enumerated(EnumType.STRING)
    private ExhibitionType titleType;

    // 타이틀노출 텍스트
    private String titleText;

    // 타이틀노출 이미지
    private String titleImage;

    // 전시코너수
    private int count;

}