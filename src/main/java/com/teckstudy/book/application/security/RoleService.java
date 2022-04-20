package com.teckstudy.book.application.security;

import com.teckstudy.book.feature.role.Role;

import java.util.List;

public interface RoleService {

    Role getRole(long id);

    List<Role> getRoles();

    void createRole(Role role);

    void deleteRole(long id);
}