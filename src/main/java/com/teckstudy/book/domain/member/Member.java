package com.teckstudy.book.domain.member;

import com.teckstudy.book.domain.base.BaseEntity;
import com.teckstudy.book.domain.member.types.Gender;
import com.teckstudy.book.domain.member.types.MemberStatus;
import com.teckstudy.book.domain.member.types.SocialType;
import com.teckstudy.book.domain.oauth2.account.OAuth2Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(unique = true)
    private String email;

    @Column(length = 100)
    private String password;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String username;

    @Enumerated(EnumType.STRING)
    private Gender sex;

    @Column(length = 8)
    private String birthday;

    @Column(length = 11)
    private String phoneNumber;

    //    @Embedded
    private String address;

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;

    @OneToOne(mappedBy = "member")
    private AuthInfo authInfo;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "SOCIAL_ID")
    private OAuth2Account social;

    public SocialType getSocialType() {
        return this.getSocialType();
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateEmail(String email) {
        this.email = email;
    }

    public void linkSocial(OAuth2Account oAuth2Account) {
//        Assert.state(social == null, "하나의 소셜 서비스만 연동할 수 있습니다.");
        this.social = oAuth2Account;
        oAuth2Account.linkUser(this);
    }

    public void unlinkSocial() {
        Assert.state(!socialType.equals(SocialType.DEFAULT), "소셜 계정으로 가입된 계정은 연동 해제가 불가능합니다.");
        Assert.state(social != null, "연동된 소셜 계정 정보가 없습니다.");
        this.social.unlinkUser();
        this.social = null;
    }
}