package com.teckstudy.book.application.member.dto;

import com.teckstudy.book.domain.member.AuthInfo;
import com.teckstudy.book.domain.role.Role;
import com.teckstudy.book.domain.member.types.Gender;
import com.teckstudy.book.domain.member.types.MemberStatus;
import com.teckstudy.book.domain.member.types.SocialType;
import com.teckstudy.book.domain.oauth2.account.OAuth2Account;
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
    private Gender sex;
    private String birthday;
    private String phoneNumber;
    private String address;
    private MemberStatus memberStatus;
    private AuthInfo authInfo;
    private SocialType socialType;
    private OAuth2Account social;
    private String baseUrl;
    private String bucketName;
    private String imageUrl;
    private List<String> roles;

    public MemberDto(Long memberId, String email, String password, String name, String username, Gender sex,
                     String birthday, String phoneNumber, String address, MemberStatus memberStatus, AuthInfo authInfo,
                     SocialType socialType, OAuth2Account social, String baseUrl, String bucketName, String imageUrl,
                     List<String> roles) {
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
        this.authInfo = authInfo;
        this.socialType = socialType;
        this.social = social;
        this.baseUrl = baseUrl;
        this.bucketName = bucketName;
        this.imageUrl = imageUrl;
        this.roles = roles;
    }
}