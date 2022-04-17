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
public class SuccessResponse<T> {
    private String code;
    private String message;
    private T data;

    private SuccessResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> SuccessResponse of(String code, String message, T data) {
        return new SuccessResponse(code,message,data);
    }
}