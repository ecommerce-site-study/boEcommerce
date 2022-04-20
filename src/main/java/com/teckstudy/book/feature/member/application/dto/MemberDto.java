package com.teckstudy.book.feature.member.application.dto;

import com.teckstudy.book.core.types.GenderType;
import com.teckstudy.book.core.types.MemberStatusType;
import com.teckstudy.book.core.types.SocialType;
import com.teckstudy.book.feature.oauth2.account.OAuth2Account;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
public class MemberDto {

    private Long memberId;
    private String email;
    private String password;
    private String name;
    private String username;
    private GenderType sex;
    private String birthday;
    private String phoneNumber;
    private String address;
    private MemberStatusType memberStatus;
    private SocialType socialType;
    private OAuth2Account social;
    private String baseUrl;
    private String bucketName;
    private String imageUrl;
    private List<String> roles;

    public MemberDto(Long memberId, String email, String password, String name, String username, GenderType sex, String birthday, String phoneNumber, String address, MemberStatusType memberStatus, SocialType socialType, OAuth2Account social, String baseUrl, String bucketName, String imageUrl, List<String> roles) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.memberStatus = memberStatus;
        this.socialType = socialType;
        this.social = social;
        this.baseUrl = baseUrl;
        this.bucketName = bucketName;
        this.imageUrl = imageUrl;
        this.roles = roles;
    }
}