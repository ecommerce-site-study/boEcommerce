package com.teckstudy.book.feature.auth_verify.ui.request;

import com.teckstudy.book.core.types.AuthInfoType;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <pre>
 * com.teckstudy.book.feature.ui.member.request
 *      PhoneNumberAuthRequest
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-16 오전 1:07
 */

@Getter
public class AuthRequest implements Serializable {

    private static final long serialVersionUID = -294679248324742964L;

    @NotBlank
    private String authIdentity;
}
