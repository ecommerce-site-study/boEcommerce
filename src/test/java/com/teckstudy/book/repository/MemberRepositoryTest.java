//package com.teckstudy.book.repository;
//
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import com.teckstudy.book.domain.member.Member;
//import com.teckstudy.book.domain.member.repository.MemberRepository;
//import com.teckstudy.book.domain.member.types.GenderType;
//import com.teckstudy.book.domain.member.types.MemberStatus;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertAll;
//
//@SpringBootTest
//@Transactional
//@Rollback(value = false)
//class MemberRepositoryTest {
//    @Autowired // 또는 자바 표준 스택 @PersistenceContext 최신버전부터 @Autowired 지원 됨
//    EntityManager em;
//
//    // queryDsl  선언
//    JPAQueryFactory queryFactory;
//
//    @Autowired
//    MemberRepository memberRepository;
//
//    private Member member;
//
//    @BeforeEach
//    public void setup() {
//        member = new Member("prodo@naver.com","1234", "홍길동",
//                GenderType.MALE, "19900912", "01020271163",
//                "서울특별시 봉천동", MemberStatus.NORMAL);
//    }
//
//    @Test
//    @DisplayName("회원가입 검증")
//    public void memberSaveTest() {
//        Member memberResult = new Member("prodo2@naver.com","1234", "홍길동",
//                GenderType.MALE, "19900912", "01020271163",
//                "서울특별시 봉천동", MemberStatus.NORMAL);
//
//        memberRepository.save(memberResult);
//
//        assertAll(
//                () -> assertThat(memberResult.getMemberId()).isNotNull(),
//                () -> assertThat(memberResult.getName()).isEqualTo(member.getName()),
//                () -> assertThat(memberResult.getPassword()).isEqualTo(member.getPassword())
//        );
//    }
//
//    @Test
//    @DisplayName("회원조회")
//    public void memberSearch() {
//        Member memberResult = new Member("prodo3@naver.com","1234", "홍길동",
//                GenderType.MALE, "19900912", "01020271163",
//                "서울특별시 봉천동", MemberStatus.NORMAL);
//        memberRepository.save(memberResult);
//
//        Member memberInfo = memberRepository.findByEmail(memberResult.getEmail()).get();
//
//        assertAll(
//                () -> assertThat(memberInfo.getMemberId()).isNotNull(),
//                () -> assertThat(memberInfo.getName()).isEqualTo(member.getName()),
//                () -> assertThat(memberInfo.getPassword()).isEqualTo(member.getPassword())
//        );
//    }
//
//    @Test
//    @DisplayName("사용자 삭제 테스트")
//    void delete() {
//        Member memberResult = new Member("prodo2@naver,com","1234", "홍길동",
//                GenderType.MALE, "19900912", "01020271163",
//                "서울특별시 봉천동", MemberStatus.NORMAL);
//        memberRepository.save(memberResult);
//        memberRepository.deleteById(memberResult.getMemberId());
//
//        assertThat(memberRepository.findById(memberResult.getMemberId())).isNotPresent();
//    }
//
////    @BeforeEach
////    public void testEntity() {
////        queryFactory = new JPAQueryFactory(em);
////
//////        memberRepository.save(member1);
//////
//////        SocialInfo socialInfo1 = SocialInfo.builder()
//////                    .member_sn(member1.getMember_sn())
//////                    .sns_code("1234-9988")
//////                    .sns_type(SocialType.F)
//////                    .build();
//////        em.persist(socialInfo1);
//////
//////        Vertity vertity = Vertity.builder()
//////                    .member_sn(member1.getMember_sn())
//////                    .auth_code("HOT-1163")
//////                    .auth_yn(YesNoStatus.Y)
//////                    .member_auth_type(AuthInfoType.PHONE)
//////                    .build();
//////
//////        em.persist(vertity);
////
////        // 영속 컨텍스트를 플러시 하는방법
////        // 1. em.flush();
////        // 2. 트랜잭션 커밋 : 플러시 자동호출
////        // 3. JPQL 쿼리실행 - 플러시 자동 호출
////    }
////
////    /**
////     *  회원가입 테스트
////     */
////    @Test
////    @DisplayName("회원가입 테스트")
////    public void memberTest() {
////        // 엔티티가 없을때는 반드시 빌드를 해줘야합니다. (Gradle -> querydsl < Tasks < other < compileQuerydsl
////        // QMember m = new QMember("m"); // 방법 1
////        // QMember m = QMember.member; // 방법 2
////        // 방법 : 매개변수 파라미터에 QMember.member 선언 후 alt+enter를 통해 static 선언
//////        List<Member> findMember = queryFactory
//////                .selectFrom(member)
//////                .join(member.snsInfo, snsInfo)
//////                .join(member.vertity, vertity)
//////                .where(member.member_id.eq("member1"))
//////                .fetch();
//////
//////        for (Member member1 : findMember) {
//////            assertThat(member1.getMember_id()).isEqualTo("member1");
//////        }
////
////    }
//
//}