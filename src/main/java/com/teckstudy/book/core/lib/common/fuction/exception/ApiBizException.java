package com.teckstudy.book.core.lib.common.fuction.exception;

import com.teckstudy.book.core.lib.common.message.api.ExhibitionCode;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

public class ApiBizException {

    private static final long serialVersionUID = 1L;

    @Getter
    private ExhibitionCode code;
    private String message;
    public ApiBizException(ExhibitionCode code) {
        this.code = code;
    }
    public ApiBizException(ExhibitionCode code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return "[" + this.code.getCode() + "] " + (StringUtils.isNotEmpty(this.message) ? this.message : this.code.getMsg());
    }
    public String getMsg() {
        return this.message;
    }
}