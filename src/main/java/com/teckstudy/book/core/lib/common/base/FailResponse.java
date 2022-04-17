package com.teckstudy.book.core.lib.common.base;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * com.teckstudy.book.lib.common.base
 *      SuccessResponse
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-01-20 오전 2:55
 */

@Getter
@NoArgsConstructor
public class FailResponse<T> {
    private String code;
    private String message;

    private FailResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> FailResponse of(String code, String message) {
        return new FailResponse(code,message);
    }
}