package com.teckstudy.book.domain.member.types;

public enum SocialType {
    DEFAULT, KAKAO, NAVER, FACEBOOK, GOOGLE
    ;

    public static SocialType findSocialType(String socialType) {
        return valueOf(socialType.toUpperCase());
    }
}
