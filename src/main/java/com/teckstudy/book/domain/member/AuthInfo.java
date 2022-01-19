package com.teckstudy.book.domain.member;

import com.teckstudy.book.domain.base.types.YesNoStatus;
import com.teckstudy.book.domain.member.types.AuthInfoType;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class AuthInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authInfoId;

    @Column(length = 100)
    private String authInfoCode;

    @Enumerated(EnumType.STRING)
    private YesNoStatus authInfoStatus;

    @Enumerated(EnumType.STRING)
    private AuthInfoType authInfoType;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Long getAuthInfoId() {
        return authInfoId;
    }

    public String getAuthInfoCode() {
        return authInfoCode;
    }

    public YesNoStatus getAuthInfoStatus() {
        return authInfoStatus;
    }

    public AuthInfoType getAuthInfoType() {
        return authInfoType;
    }
}