package com.teckstudy.book.application.security.impl;

import com.teckstudy.book.application.security.RoleHierarchyService;
import com.teckstudy.book.domain.resource.RoleHierarchy;
import com.teckstudy.book.domain.resource.repository.RoleHierarchyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

/**
 * Role정보를 가져와서 처리
 */
@Service
public class RoleHierarchyServiceImpl implements RoleHierarchyService {

    @Autowired
    private RoleHierarchyRepository roleHierarchyRepository;

    @Transactional
    @Override
    public String findAllHierarchy() {
        
        // DB에서 계층 권한 가져옴
        List<RoleHierarchy> rolesHierarchy = roleHierarchyRepository.findAll();

        Iterator<RoleHierarchy> itr = rolesHierarchy.iterator();
        StringBuffer concatedRoles = new StringBuffer();
        while (itr.hasNext()) {
            RoleHierarchy model = itr.next();
            if (model.getParentName() != null) {
                concatedRoles.append(model.getParentName().getChildName());
                concatedRoles.append(" > ");
                concatedRoles.append(model.getChildName());
                concatedRoles.append("\n");
            }
        }
        return concatedRoles.toString();

    }
}