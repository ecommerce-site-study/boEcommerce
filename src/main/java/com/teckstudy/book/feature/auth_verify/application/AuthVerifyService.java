package com.teckstudy.book.feature.auth_verify.application;

import com.teckstudy.book.core.lib.common.fuction.exception.AuthVerifyException;
import com.teckstudy.book.core.lib.common.util.RandomUtils;
import com.teckstudy.book.core.types.AuthInfoType;
import com.teckstudy.book.feature.auth_verify.domain.AuthVerify;
import com.teckstudy.book.feature.auth_verify.domain.AuthVerifyDataprovider;
import com.teckstudy.book.feature.auth_verify.ui.request.AuthRequest;
import com.teckstudy.book.feature.auth_verify.ui.request.AuthVerifyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class AuthVerifyService {

    private final AuthVerifyDataprovider authVerifyDataprovider;

    @Transactional
    public void createAuthVerify(AuthInfoType type, AuthRequest request) {

        String authIdentity = request.getAuthIdentity();
        AuthVerify authVerify= authVerifyDataprovider.enabledAuthVerify(type, authIdentity);

        checkAlreadyCertification(authVerify);
        checkAuthenticatingAuthVerify(authVerify);

        authVerifyDataprovider.save(AuthVerify.authVerify(type, authIdentity, RandomUtils.verify(6)));
    }

    @Transactional
    public void verify(AuthInfoType type, AuthVerifyRequest request) {
        AuthVerify authVerify = authVerifyDataprovider.enabledAuthVerify(type, request.getAuthIdentity());
        checkNotExistAuthVerify(authVerify);
        checkAlreadyCertification(authVerify);

        if(authVerify.isNotMatched(request.getAuthCode())) {
            throw AuthVerifyException.AUTH_VERIFY_NOT_MATCHED.throwException();
        }

        authVerify.certification();
    }

    private void checkAlreadyCertification(AuthVerify authVerify){
        if(Objects.nonNull(authVerify) && authVerify.isCertification()) {
            throw AuthVerifyException.IS_ALREADY_CERTIFICATION.throwException();
        }
    }

    private void checkAuthenticatingAuthVerify(AuthVerify authVerify) {
        if (Objects.nonNull(authVerify)) {
            authVerify.expired();
        }
    }

    private void checkNotExistAuthVerify(AuthVerify authVerify) {
        if (Objects.isNull(authVerify)) {
            throw AuthVerifyException.AUTH_VERIFY_NOT_FOUND.throwException();
        }
    }
}
