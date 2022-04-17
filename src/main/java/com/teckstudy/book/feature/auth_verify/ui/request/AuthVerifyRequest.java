package com.teckstudy.book.feature.auth_verify.ui.request;


import com.teckstudy.book.core.types.AuthInfoType;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class AuthVerifyRequest implements Serializable {

    private static final long serialVersionUID = 8193613902146150782L;

    private AuthInfoType type;
    private String authIdentity;
    private String authCode;

    public void type(AuthInfoType type) {
        this.type = type;
    }
}
