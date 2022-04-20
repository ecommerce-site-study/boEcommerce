package com.teckstudy.book.application.security;

import com.teckstudy.book.application.member.dto.MemberDto;
import com.teckstudy.book.domain.member.Member;

import java.util.List;

public interface UserService {

    void createUser(Member member);

    void modifyUser(MemberDto accountDto);

    List<Member> getUsers();

    MemberDto getUser(Long id);

    void deleteUser(Long idx);

    void order();
}
