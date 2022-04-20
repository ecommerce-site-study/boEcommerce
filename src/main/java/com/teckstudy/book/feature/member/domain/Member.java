package com.teckstudy.book.feature.member.domain;

import com.teckstudy.book.core.types.GenderType;
import com.teckstudy.book.core.types.MemberStatusType;
import com.teckstudy.book.core.types.SocialType;
import com.teckstudy.book.feature.auth_verify.domain.AuthVerify;
import com.teckstudy.book.feature.base.BaseEntity;
import com.teckstudy.book.feature.oauth2.account.OAuth2Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@NoArgsConstructor
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
    private GenderType sex;

    @Column(length = 8)
    private String birthday;

    @Column(length = 11)
    private String phoneNumber;

    private String address;

    @Enumerated(EnumType.STRING)
    private MemberStatusType memberStatus;

    @OneToOne(mappedBy = "member")
    private AuthInfo authInfo;

    @OneToOne
    private AuthVerify authVerify;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "SOCIAL_ID")
    private OAuth2Account social;

    @Column(columnDefinition = "longtext")
    private String baseUrl; // https://s3.amazon.com

    @Column(columnDefinition = "longtext")
    private String bucketName; // image

    @Column(columnDefinition = "longtext")
    private String imageUrl; // default image 달라 .

    @ManyToMany(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
    @JoinTable(name = "member_roles", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "role_id") })
    private Set<Role> memberRoles = new HashSet<>();

    public SocialType getSocialType() {
        return this.socialType;
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

    // 계층권한
    public void setMemberRoles(Set<Role> memberRoles) {
        this.memberRoles = memberRoles;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getMemberRoles() {
        return memberRoles;
    }



    public void certificate(AuthVerify authVerify) {
        this.authVerify = authVerify;
    }
}