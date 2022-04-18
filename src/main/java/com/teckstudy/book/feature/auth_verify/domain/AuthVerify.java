package com.teckstudy.book.feature.auth_verify.domain;

import com.teckstudy.book.core.types.AuthInfoStatusType;
import com.teckstudy.book.core.types.AuthInfoType;
import com.teckstudy.book.feature.base.BaseEntity;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * <pre>
 * com.teckstudy.book.core.domain.auth_verify
 *      AuthVerify
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-16 오전 1:36
 */

@Entity
@NoArgsConstructor
public class AuthVerify extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private AuthInfoType authType;

    private String authIdentity;
    private String authCode;

    @Enumerated(value = EnumType.STRING)
    private AuthInfoStatusType status;

    private AuthVerify(AuthInfoType authType, String authIdentity, String authCode, AuthInfoStatusType status) {
        this.authType = authType;
        this.authIdentity = authIdentity;
        this.authCode = authCode;
        this.status = status;
    }

    public static AuthVerify authVerify(AuthInfoType type, String verifyIdentity, String verifyCode) {
        return new AuthVerify(type, verifyIdentity, verifyCode, AuthInfoStatusType.AUTHENTICATING);
    }

    public boolean isNotMatched(String verifyCode) {
        return !this.authCode.equalsIgnoreCase(verifyCode);
    }

    public void expired() {
        this.status = AuthInfoStatusType.EXPIRED;
    }

    public void certification() {
        this.status = AuthInfoStatusType.CERTIFIED;
    }

    public boolean isCertification() {
        return this.status == AuthInfoStatusType.CERTIFIED;
    }
}
