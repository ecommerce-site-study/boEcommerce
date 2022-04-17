package com.teckstudy.book.core.lib.common.base;

import lombok.NoArgsConstructor;

/**
 * <pre>
 * com.teckstudy.book.core.lib.common.base
 *      BaseApiException
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-17 오후 11:12
 */

@NoArgsConstructor
public abstract class BaseApiException extends RuntimeException{

    private static final long serialVersionUID = -6028783977605479720L;

    private String code;
    private String message;

    protected BaseApiException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
