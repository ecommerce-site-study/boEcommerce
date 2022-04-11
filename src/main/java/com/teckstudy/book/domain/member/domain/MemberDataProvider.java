package com.teckstudy.book.domain.member.domain;

import com.teckstudy.book.domain.member.Member;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface MemberDataProvider {

    Optional<Member> findByEmail(String email);

    Optional<Member> findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    void save(Member member);

    void delete(Member member);
}
