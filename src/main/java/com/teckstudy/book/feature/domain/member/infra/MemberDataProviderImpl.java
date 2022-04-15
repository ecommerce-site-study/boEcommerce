package com.teckstudy.book.feature.domain.member.infra;

import com.teckstudy.book.core.domain.member.Member;
import com.teckstudy.book.feature.domain.member.domain.MemberDataProvider;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MemberDataProviderImpl implements MemberDataProvider {

    private MemberRepository memberRepository;

    @Override
    public Optional<Member> findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    @Override
    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return memberRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByUsername(String username) {
        return memberRepository.existsByUsername(username);
    }

    @Override
    public void save(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void delete(Member member) {
        memberRepository.delete(member);
    }
}
