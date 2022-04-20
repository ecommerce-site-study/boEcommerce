package com.teckstudy.book.ui.user;

import com.teckstudy.book.config.security.token.AjaxAuthenticationToken;
import com.teckstudy.book.feature.member.application.MemberService;
import com.teckstudy.book.feature.member.application.dto.MemberDto;
import com.teckstudy.book.feature.member.domain.Member;
import com.teckstudy.book.feature.role.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping(value="/users")
    public String createUser() throws Exception {

        return "user/login/register";
    }

    @PostMapping(value="/users")
    public String createUser(MemberDto memberDto) throws Exception {

        ModelMapper modelMapper = new ModelMapper();
        Member member = modelMapper.map(memberDto, Member.class);
        member.setPassword(passwordEncoder.encode(memberDto.getPassword()));

        member.setUsername("user");
        member.setName("sungrak");

        memberService.createUser(member);

        return "redirect:/";
    }

    @GetMapping(value="/mypage")
    public String myPage(@AuthenticationPrincipal Member member, Authentication authentication, Principal principal) throws Exception {

        String username1 = member.getUsername();
        System.out.println("username1 = " + username1);

        Member member2 = (Member) authentication.getPrincipal();
        String username2 = member2.getUsername();
        System.out.println("username2 = " + username2);

        Member member3 = null;
        if (principal instanceof UsernamePasswordAuthenticationToken) {
            member3 = (Member) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();

        }else if(principal instanceof AjaxAuthenticationToken){
            member3 = (Member) ((AjaxAuthenticationToken) principal).getPrincipal();
        }

        String username3 = member3.getUsername();
        System.out.println("username3 = " + username3);

        Member account4 = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username4 = account4.getUsername();
        System.out.println("username4 = " + username4);

        return "user/mypage";
    }

//    @GetMapping("/mypage")
//    public String order(){
//        userService.order();
//        return "user/mypage";
//    }
}