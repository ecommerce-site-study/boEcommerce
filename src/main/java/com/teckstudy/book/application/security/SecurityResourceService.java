package com.teckstudy.book.application.security;

import com.teckstudy.book.domain.resource.Resources;
import com.teckstudy.book.domain.resource.repository.ResourcesRepository;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class SecurityResourceService {

    private ResourcesRepository resourcesRepository;

    public SecurityResourceService(ResourcesRepository resourcesRepository) {
        this.resourcesRepository = resourcesRepository;
    }

    /**
     * 자원과 권한 가져오기 url 방식
     * @return
     */
    public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getResourceList() {

        LinkedHashMap<RequestMatcher, List<ConfigAttribute>> result = new LinkedHashMap<>();
        List<Resources> resourcesList = resourcesRepository.findAllResources(); // db정보를 가져옴
        // 리소스를 돌때마다
        resourcesList.forEach(re -> {
            List<ConfigAttribute> configAttributeList = new ArrayList<>();
            // 권한정보
            re.getRoleSet().forEach(role -> {
                configAttributeList.add(new SecurityConfig(role.getRoleName())); // db에서 가져온 role 정보
                // 리소스 하나당 일 대다 구조로 매핑함
                result.put(new AntPathRequestMatcher(re.getResourceName()), configAttributeList);
            });

        });

        return result;
    }
}