package com.teckstudy.book.feature.member.domain;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface MemberDataProvider {

    Optional<Member> findByEmail(String email);

    Optional<Member> findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    void save(Member member);

    void delete(Member member);

    void deleteById(Long id);

    List<Member> findAll();

    Optional<Member> findById(Long id);
}
