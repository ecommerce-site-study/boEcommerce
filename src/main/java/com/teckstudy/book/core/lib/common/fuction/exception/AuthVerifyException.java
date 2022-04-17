package com.teckstudy.book.core.lib.common.fuction.exception;

import com.teckstudy.book.core.lib.common.base.BaseApiException;
import com.teckstudy.book.core.lib.common.base.BaseException;

/**
 * <pre>
 * com.teckstudy.book.core.lib.common.fuction.exception
 *      AuthVerifyException
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-17 오후 11:11
 */

public enum AuthVerifyException implements BaseException<AuthVerifyException.AuthVerifyBaseException> {

    IS_ALREADY_CERTIFICATION("200200", "이미 인증된 휴대폰 번호입니다"),

    AUTH_VERIFY_NOT_FOUND("200404", "존재하지 않는 인증 정보입니다"),
    AUTH_VERIFY_NOT_MATCHED("200406", "잘못된 인증 코드입니다")
    ;

    private final String code;
    private final String message;

    AuthVerifyException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public class AuthVerifyBaseException extends BaseApiException {

        private static final long serialVersionUID = 2424361112998283526L;

        public AuthVerifyBaseException(String code, String message) {
            super(code,message);
        }
    }

    @Override
    public AuthVerifyException.AuthVerifyBaseException throwException() {
        return new AuthVerifyException.AuthVerifyBaseException(this.code, this.message);
    }
}
