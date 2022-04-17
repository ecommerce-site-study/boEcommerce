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
    private Long status;
    private String message;
    private T data;

    private SuccessResponse(Long status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> SuccessResponse of(Long status, String message, T data) {
        return new SuccessResponse(status,message,data);
    }
}