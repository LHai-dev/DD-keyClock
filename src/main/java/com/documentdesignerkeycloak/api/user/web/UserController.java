package com.documentdesignerkeycloak.api.user.web;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = {"/api/v1/user"})
@Log4j2
public class UserController {

    @GetMapping
    public String getWelcome(){
        return "Hello now u are free no security";
    }

    @GetMapping(value = {"/home"})
    public String getHome(){
        return "Hello now u are free no security";
    }
	@PostMapping("/archive")
	Map<String,String> archiveMessages() {
		log.info("Hello now u are free no security");
		return Map.of("status", "success");
	}

}
