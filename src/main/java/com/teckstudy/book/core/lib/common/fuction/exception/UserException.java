package com.teckstudy.book.core.lib.common.fuction.exception;

import com.teckstudy.book.core.lib.common.base.BaseApiException;
import com.teckstudy.book.core.lib.common.base.BaseException;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * com.teckstudy.book.core.lib.common.fuction.exception
 *      UserException
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-17 오후 11:11
 */

public enum UserException implements BaseException<UserException.UserBaseException> {
    USER_ID_IS_ALREADY_EXISTS("100409", "이미 존재하는 ID 입니다"),
    USER_NOT_FOUND("100404", "존재하지 않는 유저 ID 입니다")
    ;

    private final String code;
    private final String message;

    UserException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public class UserBaseException extends BaseApiException {

        private static final long serialVersionUID = 1849592506377612121L;

        public UserBaseException(String code, String message) {
            super(code,message);
        }
    }

    @Override
    public UserBaseException throwException() {
        return new UserBaseException(this.code, this.message);
    }
}
