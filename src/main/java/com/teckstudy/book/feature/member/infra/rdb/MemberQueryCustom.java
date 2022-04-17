package com.teckstudy.book.feature.member.infra.rdb;

import com.teckstudy.book.feature.member.domain.Member;

import java.util.Optional;

public interface MemberQueryCustom {
    Optional<Member> findByEmail(String email);
    Optional<Member> findByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
