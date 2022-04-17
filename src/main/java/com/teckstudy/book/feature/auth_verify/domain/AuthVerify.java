package com.teckstudy.book.feature.auth_verify.domain;

import com.teckstudy.book.core.types.AuthInfoType;
import com.teckstudy.book.feature.base.BaseEntity;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    private AuthInfoType authType;

    private String verifyIdentity;
    private String verifyCode;

    private AuthVerify(AuthInfoType authType, String verifyIdentity, String verifyCode) {
        this.authType = authType;
        this.verifyIdentity = verifyIdentity;
        this.verifyCode = verifyCode;
    }

    public static AuthVerify authVerify(AuthInfoType type, String verifyIdentity, String verifyCode) {
        return new AuthVerify(type, verifyIdentity, verifyCode);
    }

    public boolean isMatched(String verifyCode) {
        return this.verifyCode.equalsIgnoreCase(verifyCode);
    }
}
