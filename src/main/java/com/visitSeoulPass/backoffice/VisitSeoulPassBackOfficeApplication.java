package com.visitSeoulPass.backoffice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.boot.builder.SpringApplicationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class VisitSeoulPassBackOfficeApplication extends SpringBootServletInitializer implements CommandLineRunner {
    
    private static final Logger log = LoggerFactory.getLogger(VisitSeoulPassBackOfficeApplication.class);
    
    @Value("${spring.project.name}")
    private String prjName;

    @Value("${spring.project.version}")
    private String prjVersion;

    @Value("${spring.project.description}")
    private String prjDesc;

    @Value("${spring.profiles.active}")
    private String profile;

    @Value("${server.port}")
    private String port;
    
    public static void main(String[] args) {
        SpringApplication.run(VisitSeoulPassBackOfficeApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(VisitSeoulPassBackOfficeApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(" ");
        log.info("============================================================");
        log.info("  ***** PROJECT OUTLINE *****");
        log.info("------------------------------------------------------------");
        log.info("         NAME : {}", prjName);
        log.info("      VERSION : {}", prjVersion);
        log.info("      PROFILE : {}", profile);
        log.info("  DESCRIPTION : {}", prjDesc);
        log.info("------------------------------------------------------------");
        log.info("         PORT : {}", port);
        log.info("============================================================");
        log.info(" ");
    }
}
