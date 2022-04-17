package com.teckstudy.book.feature.auth_verify.domain;

import com.teckstudy.book.core.types.AuthInfoType;

import java.util.Optional;

public interface AuthVerifyDataprovider {

    public void save(AuthVerify authVerify);

    Optional<AuthVerify> findAuthVerifyByType(AuthInfoType type, String authIdentity);
}
