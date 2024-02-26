package com.documentdesignerkeycloak.api.user.web;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {

    @GetMapping("/public")
    public String getEveryoneText() {
        return "Both ADMIN and USER can access this!!";
    }

    @GetMapping("/user")
    public String getUserText() {
        return "hello USER";
    }

    @GetMapping("/admin")
    public String getAdminText() {
        return "hello ADMIN";
    }
}
