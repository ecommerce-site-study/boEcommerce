package com.teckstudy.book.domain.member.repository;

import com.teckstudy.book.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 스프링 데이터 리포지토리에 사용자 정의 인터페이스 상속 (MemberRepositoryCustom)
// QuerydslPredicateExecutor<Member> 생략
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail (String email);
}
