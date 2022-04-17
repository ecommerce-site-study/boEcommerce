package com.teckstudy.book.feature.auth_verify.infra.rdb;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.teckstudy.book.core.types.AuthInfoType;
import com.teckstudy.book.feature.auth_verify.domain.AuthVerify;
import com.teckstudy.book.feature.auth_verify.domain.QAuthVerify;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.teckstudy.book.feature.auth_verify.domain.QAuthVerify.authVerify;

@RequiredArgsConstructor
public class AuthVerifyQueryCustomImpl implements AuthVerifyQueryCustom {

    private final JPAQueryFactory queryFactory;
    private final QAuthVerify qAuthVerify = authVerify;

    @Override
    public Optional<AuthVerify> findAuthVerifyByType(AuthInfoType type, String authIdentity) {

        return Optional.ofNullable(queryFactory
                .selectFrom(qAuthVerify)
                .where(
                        qAuthVerify.authType.eq(type),
                        qAuthVerify.verifyIdentity.eq(authIdentity)
                )
                .orderBy(qAuthVerify.regDate.desc())
                .limit(1)
                .fetchOne());
    }
}
