/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.azrul.keycloak.projectmgmtsystem.repository;

import com.azrul.keycloak.projectmgmtsystem.domain.ProjectRequest;
import jakarta.annotation.PostConstruct;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author azrul
 */
@Component
public class Init {
    @Autowired
    ProjectRequestRepository projectRequestDAO;
    
    
    @PostConstruct
    public void init(){
        ProjectRequest p = new ProjectRequest();
        p.setBudget(10000);
        p.setProjectName("Project X");
        p.setStartDate(LocalDate.now());
        projectRequestDAO.save(p);
    }
}
