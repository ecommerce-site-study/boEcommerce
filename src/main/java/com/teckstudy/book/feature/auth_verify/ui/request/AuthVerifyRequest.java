package com.teckstudy.book.feature.auth_verify.ui.request;


import com.teckstudy.book.core.types.AuthInfoType;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
public class AuthVerifyRequest implements Serializable {

    private static final long serialVersionUID = 8193613902146150782L;

    @NotBlank
    private String authIdentity;

    @NotBlank
    private String authCode;

}
