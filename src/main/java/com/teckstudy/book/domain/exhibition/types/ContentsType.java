package com.teckstudy.book.domain.exhibition.types;

import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.exhibition.Exhibition;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class ContentsType extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long content_sn;

    @Enumerated(EnumType.STRING)
    private ContentEnum contentEnum;

    private int contentCnt;


}