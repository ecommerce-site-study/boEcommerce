package com.teckstudy.book.feature.auth_verify.infra.rdb;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.teckstudy.book.core.types.AuthInfoStatusType;
import com.teckstudy.book.core.types.AuthInfoType;
import com.teckstudy.book.feature.auth_verify.domain.AuthVerify;
import com.teckstudy.book.feature.auth_verify.domain.QAuthVerify;
import lombok.RequiredArgsConstructor;

import static com.teckstudy.book.feature.auth_verify.domain.QAuthVerify.authVerify;

@RequiredArgsConstructor
public class AuthVerifyQueryCustomImpl implements AuthVerifyQueryCustom {

    private final JPAQueryFactory queryFactory;
    private final QAuthVerify qAuthVerify = authVerify;

    @Override
    public AuthVerify findEnabledAuthVerify(AuthInfoType type, String authIdentity) {
        return queryFactory
                .selectFrom(qAuthVerify)
                .where(
                        qAuthVerify.authIdentity.eq(authIdentity),
                        qAuthVerify.authType.eq(type)
                )
                .orderBy(qAuthVerify.regDate.desc())
                .limit(1)
                .fetchOne();
    }

    @Override
    public AuthVerify findCertificationAuthVerify(String authIdentity, String authCode) {
        return queryFactory
                .selectFrom(qAuthVerify)
                .where(
                        qAuthVerify.authIdentity.eq(authIdentity),
                        qAuthVerify.authCode.eq(authCode),
                        qAuthVerify.status.eq(AuthInfoStatusType.CERTIFIED)
                ).orderBy(qAuthVerify.regDate.desc())
                .limit(1)
                .fetchOne();
    }
}
