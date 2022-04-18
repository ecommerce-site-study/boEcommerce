package com.teckstudy.book.feature.member.application.mapper;

import com.teckstudy.book.core.types.MemberStatusType;
import com.teckstudy.book.core.types.SocialType;
import com.teckstudy.book.feature.member.domain.Member;
import com.teckstudy.book.feature.member.ui.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <pre>
 * com.teckstudy.book.feature.member.application.mapper
 *      MemberMapper
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-19 오전 12:03
 */

@RequiredArgsConstructor
public class MemberMapper {

    @Value("${assets.images.base-url}")
    private String baseUrl;

    @Value("${assets.images.bucket}")
    private String bucket;

    @Value("${assets.images.default")
    private String defaultAvatar;

    private final PasswordEncoder passwordEncoder;

    public Member createDefaultUser(SignUpRequest signUpRequest) {
        return Member.builder()
                .username(signUpRequest.getEmail())
                .name(signUpRequest.getName())
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .socialType(SocialType.DEFAULT)
                .baseUrl(this.baseUrl)
                .bucketName(this.bucket)
                .imageUrl(defaultAvatar)
                .memberStatus(MemberStatusType.NORMAL)
                .build();
    }
}
