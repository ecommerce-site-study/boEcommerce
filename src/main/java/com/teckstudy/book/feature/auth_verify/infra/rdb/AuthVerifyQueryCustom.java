package com.teckstudy.book.feature.auth_verify.infra.rdb;

import com.teckstudy.book.core.types.AuthInfoType;
import com.teckstudy.book.feature.auth_verify.domain.AuthVerify;

import java.util.Optional;

public interface AuthVerifyQueryCustom {

    Optional<AuthVerify> findAuthVerifyByType(AuthInfoType type, String authIdentity);
}
