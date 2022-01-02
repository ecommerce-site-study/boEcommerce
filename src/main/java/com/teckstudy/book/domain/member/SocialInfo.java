package com.teckstudy.book.domain.member;

import com.teckstudy.book.domain.BaseEntity;
import com.teckstudy.book.domain.member.types.SocialType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SocialInfo extends BaseEntity {

    @Id
    private Long socialInfoId;

    @Column(length = 100)
    private String socialCode;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

}
