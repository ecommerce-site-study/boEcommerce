package com.teckstudy.book.feature.auth_verify.infra.rdb;

import com.teckstudy.book.core.types.AuthInfoType;
import com.teckstudy.book.feature.auth_verify.domain.AuthVerify;

public interface AuthVerifyQueryCustom {
    AuthVerify findEnabledAuthVerify(AuthInfoType type, String authIdentity);
}
