package com.teckstudy.book.domain.exhibition.types;

import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.exhibition.Exhibition;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@SequenceGenerator(
        name = "CONTENTS_SEQ_GENERATOR",
        sequenceName = "CONTENTS_SEQ", // 매핑할 데이터베이스 시퀀스 이름
        initialValue = 10000001,
        allocationSize = 1)
public class ContentsType extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "CONTENTS_SEQ_GENERATOR")
    private Long content_sn;

    @Enumerated(EnumType.STRING)
    private ContentEnum contentEnum;

    private int contentCnt;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "exhibition_sn")
    private Exhibition exhibition;

}