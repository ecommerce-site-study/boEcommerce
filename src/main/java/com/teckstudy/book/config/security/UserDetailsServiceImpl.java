package com.teckstudy.book.config.security;


import com.teckstudy.book.domain.member.Member;
import com.teckstudy.book.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("등록되지 않은 회원입니다."));

        UserDetailsImpl userDetails = UserDetailsImpl.builder()
                .id(member.getMemberId())
                .username(member.getUsername())
                .name(member.getName())
                .email(member.getEmail())
                .password(member.getPassword())
                .type(member.getSocialType())
//                .authorities(member.getAuthorities())
                .build();

        return userDetails;
    }
}
