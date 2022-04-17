package com.teckstudy.book.feature.auth_verify.infra;

import com.teckstudy.book.core.types.AuthInfoType;
import com.teckstudy.book.feature.auth_verify.domain.AuthVerify;
import com.teckstudy.book.feature.auth_verify.domain.AuthVerifyDataprovider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthVerifyDataproviderImpl implements AuthVerifyDataprovider {

    private final AuthVerifyRepository authVerifyRepository;

    @Override
    public void save(AuthVerify authVerify) {
        authVerifyRepository.save(authVerify);
    }

    @Override
    public AuthVerify enabledAuthVerify(AuthInfoType type,String authIdentity) {
        return authVerifyRepository.findEnabledAuthVerify(type, authIdentity);
    }
}
