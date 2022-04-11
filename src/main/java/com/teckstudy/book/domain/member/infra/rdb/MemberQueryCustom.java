package com.teckstudy.book.domain.member.infra.rdb;

import com.teckstudy.book.domain.member.Member;

import java.util.Optional;

public interface MemberQueryCustom {
    Optional<Member> findByEmail(String email);
    Optional<Member> findByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
