package com.documentdesignerkeycloak.api.keycloak;

public record UserRegistrationRecord(String username, String email,String firstName,String lastName,String password) {
}
