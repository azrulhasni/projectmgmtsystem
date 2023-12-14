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
    public void addProject(ProjectRequest project){
        projectRequestDAO.save(project);
    }


    @GetMapping(path = "/projectrequest")
    public List<ProjectRequest> queryProjects() {
        return projectRequestDAO.findAll();
    } 
 
}
