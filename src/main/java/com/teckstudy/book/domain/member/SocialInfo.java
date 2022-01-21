package com.teckstudy.book.domain.member;

import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.member.types.SocialType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SocialInfo extends BaseEntity {

    @Id
    private Long socialInfoId;

    @Column(length = 100)
    private String socialCode;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Long getSocialInfoId() {
        return socialInfoId;
    }

    public String getSocialCode() {
        return socialCode;
    }

    public SocialType getSocialType() {
        return socialType;
    }
}