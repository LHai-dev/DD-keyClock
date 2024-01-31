package com.documentdesignerkeycloak.api.user.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api/v1/user"})
public class UserController {

    @GetMapping()
    @PreAuthorize("hasRole('client_user')")
    public String getWelcome(){
        return "Hello now u are free no security";
    }

    @GetMapping(value = {"/home"})
    @PreAuthorize("permitAll()")
    public String getHome(){
        return "Hello now u are free no security";
    }


}
