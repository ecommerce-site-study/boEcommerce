package com.teckstudy.book.domain.exhibition;

import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.exhibition.types.ContentEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@SequenceGenerator(
        name = "CONTENTS_SEQ_GENERATOR",
        sequenceName = "CONTENTS_SEQ", // 매핑할 데이터베이스 시퀀스 이름
        initialValue = 10000001,
        allocationSize = 1)
public class ContentsType extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "CONTENTS_SEQ_GENERATOR")
    private Long contentId;

    @Enumerated(EnumType.STRING)
    private ContentEnum contentEnum;

    private int contentCnt;

    @ManyToOne
    @JoinColumn(name = "exhibitionId")
    private Exhibition exhibition;

    public ContentsType(Long contentId, ContentEnum contentEnum, int contentCnt, Exhibition exhibition) {
        this.contentId = contentId;
        this.contentEnum = contentEnum;
        this.contentCnt = contentCnt;
        this.exhibition = exhibition;
    }

    public static ContentsType ofNew(ContentsType contentsTypes, Exhibition exhibition) {
        return new ContentsType(contentsTypes.contentId, contentsTypes.contentEnum, contentsTypes.contentCnt, exhibition);
    }
}