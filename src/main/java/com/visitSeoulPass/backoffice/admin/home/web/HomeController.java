package com.visitSeoulPass.backoffice.admin.home.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;

@Slf4j
// @Controller
@RestController
@RequestMapping("/api")
public class HomeController {
    
    // @GetMapping("/home")
    // public String home() {
    //     log.info("Accessing home page");
    //     return "Welcome to Visit Seoul Pass BackOffice";
    // }

    @GetMapping("/home")
	public ResponseEntity<RespDTO> getHello() {
        return APIResponse.OK();
	}
}
