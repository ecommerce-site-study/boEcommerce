package com.teckstudy.book.feature.auth_verify.domain;

import com.teckstudy.book.core.types.AuthInfoStatusType;
import com.teckstudy.book.core.types.AuthInfoType;

import java.util.Optional;

public interface AuthVerifyDataprovider {

    void save(AuthVerify authVerify);

    AuthVerify enabledAuthVerify(AuthInfoType type, String authIdentity);

    AuthVerify certificationAuthVerify(String authIdentity, String authCode);
}
