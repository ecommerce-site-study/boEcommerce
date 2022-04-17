package com.teckstudy.book.feature.auth_verify.application;

import com.teckstudy.book.core.lib.common.util.RandomUtils;
import com.teckstudy.book.feature.auth_verify.domain.AuthVerify;
import com.teckstudy.book.feature.auth_verify.domain.AuthVerifyDataprovider;
import com.teckstudy.book.feature.auth_verify.ui.request.AuthRequest;
import com.teckstudy.book.feature.auth_verify.ui.request.AuthVerifyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthVerifyService {

    private final AuthVerifyDataprovider authVerifyDataprovider;

    public void createAuthVerify(AuthRequest request) {
        AuthVerify authVerify = AuthVerify.authVerify(request.getType(), request.getAuthIdentity(), RandomUtils.verify(6));
        authVerifyDataprovider.save(authVerify);
    }

    public void verify(AuthVerifyRequest request) {
        Optional<AuthVerify> authVerify = authVerifyDataprovider.findAuthVerifyByType(request.getType(), request.getAuthIdentity());

        if(!authVerify.isPresent()) {
            // 없어서 인증 안됨
        }

        // 맞는지 인증 필요
        AuthVerify authVerify = authVerify.get();
    }
}
