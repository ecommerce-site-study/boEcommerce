package com.teckstudy.book.ui.admin;

import com.teckstudy.book.application.security.ResourcesService;
import com.teckstudy.book.application.security.RoleService;
import com.teckstudy.book.config.security.matadatasource.UrlSecurityMetadataSource;
import com.teckstudy.book.domain.resource.Resources;
import com.teckstudy.book.domain.role.Role;
import com.teckstudy.book.domain.role.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class ResourcesController {

    @Autowired
    private ResourcesService resourcesService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UrlSecurityMetadataSource urlSecurityMetadataSource; // 웹 기반 인가 실시간 반영

    @GetMapping(value="/admin/resources")
    public String getResources(Model model) throws Exception {

        List<Resources> resources = resourcesService.getResources();
        model.addAttribute("resources", resources);

        return "admin/resource/list";
    }

//    @PostMapping(value="/admin/resources")
//    public String createResources(ResourcesDto resourcesDto) throws Exception {
//
//        ModelMapper modelMapper = new ModelMapper();
//        Role role = roleRepository.findByRoleName(resourcesDto.getRoleName());
//        Set<Role> roles = new HashSet<>();
//        roles.add(role);
//        Resources resources = modelMapper.map(resourcesDto, Resources.class);
//        resources.setRoleSet(roles);
//
//        resourcesService.createResources(resources); // 자원 생성
//        urlSecurityMetadataSource.reload(); // 실시간 반영
//
//        return "redirect:/admin/resources";
//    }
//
//    @GetMapping(value="/admin/resources/register")
//    public String viewRoles(Model model) throws Exception {
//
//        List<Role> roleList = roleService.getRoles();
//        model.addAttribute("roleList", roleList);
//
//        ResourcesDto resources = new ResourcesDto();
//        Set<Role> roleSet = new HashSet<>();
//        roleSet.add(new Role());
//        resources.setRoleSet(roleSet);
//        model.addAttribute("resources", resources);
//
//        return "admin/resource/detail";
//    }
//
//    @GetMapping(value="/admin/resources/{id}")
//    public String getResources(@PathVariable String id, Model model) throws Exception {
//
//        List<Role> roleList = roleService.getRoles();
//        model.addAttribute("roleList", roleList);
//        Resources resources = resourcesService.getResources(Long.valueOf(id));
//
//        ModelMapper modelMapper = new ModelMapper();
//        ResourcesDto resourcesDto = modelMapper.map(resources, ResourcesDto.class);
//        model.addAttribute("resources", resourcesDto);
//
//        return "admin/resource/detail";
//    }
//
//    @GetMapping(value="/admin/resources/delete/{id}")
//    public String removeResources(@PathVariable String id, Model model) throws Exception {
//
//        Resources resources = resourcesService.getResources(Long.valueOf(id));
//        resourcesService.deleteResources(Long.valueOf(id)); // 자원 삭제
//        urlSecurityMetadataSource.reload(); // 실시간 반영
//
//        return "redirect:/admin/resources";
//    }
}