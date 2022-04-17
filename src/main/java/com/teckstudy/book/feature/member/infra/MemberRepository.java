package com.teckstudy.book.feature.member.infra;

import com.teckstudy.book.feature.member.domain.Member;
import com.teckstudy.book.feature.member.infra.rdb.MemberQueryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 스프링 데이터 리포지토리에 사용자 정의 인터페이스 상속 (MemberRepositoryCustom)
// QuerydslPredicateExecutor<Member> 생략

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> , MemberQueryCustom {

}