package com.teckstudy.book.feature.domain.member.infra.rdb;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.teckstudy.book.core.domain.member.Member;
import com.teckstudy.book.domain.member.QMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberQueryCustomImpl implements MemberQueryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Member> findByEmail(String email) {
        QMember qMember = QMember.member;

        return Optional.ofNullable(
                queryFactory
                        .selectFrom(qMember)
                        .where(qMember.email.eq(email))
                        .fetchOne()
        );
    }

    @Override
    public Optional<Member> findByUsername(String username) {
        QMember qMember = QMember.member;

        return Optional.ofNullable(
                queryFactory
                        .selectFrom(qMember)
                        .where(qMember.username.eq(username))
                        .fetchOne()
        );
    }

    @Override
    public boolean existsByEmail(String email) {
        QMember qMember = QMember.member;

        return Objects.nonNull(queryFactory.selectFrom(qMember)
                .where(qMember.email.eq(email))
                .fetchFirst());
    }

    @Override
    public boolean existsByUsername(String username) {
        QMember qMember = QMember.member;

        return Objects.nonNull(queryFactory.selectFrom(qMember)
                .where(qMember.username.eq(username))
                .fetchFirst());
    }
}
