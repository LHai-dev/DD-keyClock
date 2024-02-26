package com.documentdesignerkeycloak.api.keycloak;

public interface RoleService {

    void assignRole(String userId,String roleName);
}
