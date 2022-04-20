package com.teckstudy.book.application.security;

import com.teckstudy.book.feature.member.application.dto.MemberDto;
import com.teckstudy.book.feature.member.domain.Member;

import java.util.List;

public interface UserService {

    void createUser(Member member);

    void modifyUser(MemberDto accountDto);

    List<Member> getUsers();

    MemberDto getUser(Long id);

    void deleteUser(Long idx);

    void order();
}
