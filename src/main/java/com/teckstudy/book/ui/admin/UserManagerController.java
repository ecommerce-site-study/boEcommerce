package com.teckstudy.book.ui.admin;

import com.teckstudy.book.application.security.RoleService;
import com.teckstudy.book.feature.member.application.MemberService;
import com.teckstudy.book.feature.member.application.dto.MemberDto;
import com.teckstudy.book.feature.member.domain.Member;
import com.teckstudy.book.feature.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserManagerController {

    @Autowired
    private MemberService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value="/admin/accounts")
    public String getUsers(Model model) throws Exception {

        List<Member> accounts = userService.getUsers();
        model.addAttribute("accounts", accounts);

        return "admin/user/list";
    }

    @PostMapping(value="/admin/accounts")
    public String modifyUser(MemberDto memberDto) throws Exception {

        userService.modifyUser(memberDto);

        return "redirect:/admin/accounts";
    }

    @GetMapping(value = "/admin/accounts/{id}")
    public String getUser(@PathVariable(value = "id") Long id, Model model) {

        MemberDto memberDto = userService.getUser(id);
        List<Role> roleList = roleService.getRoles();

        model.addAttribute("account", memberDto);
        model.addAttribute("roleList", roleList);

        return "admin/user/detail";
    }

    @GetMapping(value = "/admin/accounts/delete/{id}")
    public String removeUser(@PathVariable(value = "id") Long id, Model model) {

        userService.deleteUser(id);

        return "redirect:/admin/users";
    }
}