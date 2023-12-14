package com.azrul.keycloak.projectmgmtsystem.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.azrul.keycloak.projectmgmtsystem")
@EnableJpaRepositories("com.azrul.keycloak.projectmgmtsystem.repository")
@EntityScan("com.azrul.keycloak.projectmgmtsystem.domain")
public class ProjectmgmtsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectmgmtsystemApplication.class, args);
	}

}
