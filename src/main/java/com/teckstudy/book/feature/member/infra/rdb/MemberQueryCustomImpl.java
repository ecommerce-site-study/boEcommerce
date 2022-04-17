package com.teckstudy.book.feature.member.infra.rdb;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.teckstudy.book.feature.member.domain.Member;
import com.teckstudy.book.feature.member.domain.QMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;

import static com.teckstudy.book.feature.member.domain.QMember.member;

@Repository
@RequiredArgsConstructor
public class MemberQueryCustomImpl implements MemberQueryCustom {

    private final JPAQueryFactory queryFactory;
    private final QMember qMember = member;

    @Override
    public Optional<Member> findByEmail(String email) {
        return Optional.ofNullable(
                queryFactory
                        .selectFrom(qMember)
                        .where(qMember.email.eq(email))
                        .fetchOne()
        );
    }

    @Override
    public Optional<Member> findByUsername(String username) {
        return Optional.ofNullable(
                queryFactory
                        .selectFrom(qMember)
                        .where(qMember.username.eq(username))
                        .fetchOne()
        );
    }

    @Override
    public boolean existsByEmail(String email) {
        return Objects.nonNull(queryFactory.selectFrom(qMember)
                .where(qMember.email.eq(email))
                .fetchFirst());
    }

    @Override
    public boolean existsByUsername(String username) {
        return Objects.nonNull(queryFactory.selectFrom(qMember)
                .where(qMember.username.eq(username))
                .fetchFirst());
    }
}
