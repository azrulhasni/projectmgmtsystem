/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.azrul.keycloak.projectmgmtsystem.repository;

import com.azrul.keycloak.projectmgmtsystem.domain.ProjectRequest;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author azrul
 */
public interface ProjectRequestRepository extends JpaRepository<ProjectRequest, Long> {

}
