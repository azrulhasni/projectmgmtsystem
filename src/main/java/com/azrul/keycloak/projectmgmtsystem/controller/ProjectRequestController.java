package com.azrul.keycloak.projectmgmtsystem.controller;

import com.azrul.keycloak.projectmgmtsystem.domain.ProjectRequest;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.azrul.keycloak.projectmgmtsystem.repository.ProjectRequestRepository;
import java.security.Principal;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author azrul
 */
@RestController
public class ProjectRequestController {

//    @Autowired
//    Keycloak keycloak;
    
    @Autowired
    ProjectRequestRepository projectRequestDAO;

    @GetMapping(path = "/")
    public String index() {
        return "public facing";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {
        request.logout();
        return "logout";
    }
    
    @PostMapping(path = "/projectrequest")
    public String addProject(ProjectRequest project){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Set<String> roles = authentication.getAuthorities().stream().map(r -> r.getAuthority()).collect(Collectors.toSet());
        if (roles.contains("ProjectRequestor")){
            projectRequestDAO.save(project);
            return "SUCCESS";
        }else{
            return "FAIL";
        }
    }


    @GetMapping(path = "/projectrequest")
    public List<ProjectRequest> queryProjects() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Set<String> roles = authentication.getAuthorities().stream().map(r -> r.getAuthority()).collect(Collectors.toSet());
        if (roles.contains("ProjectApprover")){
            return projectRequestDAO.findAll();
        }else{
            return List.of();
        }
    } 
 
}
