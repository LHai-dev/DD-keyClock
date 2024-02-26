package com.documentdesignerkeycloak.api.keycloak;

import jakarta.ws.rs.core.Response;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KeycloakAdminClientExample {


//     public static void main(String[] args) {

//         // User "idm-admin" needs at least "manage-users, view-clients, view-realm, view-users" roles for "realm-management"
//         String authServerUrl = "http://localhost:8280";
//         String realm = "dev-keycloak";
//         // Hardcoded values for testing, replace with actual values
//         String adminClientId = "admin-cli";
//         String adminClientSecret = "TzfTf6Tzb48qsc0YI1lfiJZLwQtf3wgk";
//         Keycloak keycloak = KeycloakBuilder.builder() //
//                 .serverUrl(authServerUrl) //
//                 .realm(realm) //
//                 .grantType(OAuth2Constants.CLIENT_CREDENTIALS) //
//                 .clientId(adminClientId) //
//                 .clientSecret(adminClientSecret) //
//                 .build();

//         // Define user
//         UserRepresentation user = new UserRepresentation();
//         user.setEnabled(true);
//         user.setUsername("dddd");
//         user.setFirstName("Fiddddrst");
//         user.setLastName("Laddddst");
//         user.setEmail("tom+ddddtester1@tdlddabs.local");
//         user.setAttributes(Collections.singletonMap("origin", Arrays.asList("demo")));
//         user.setRealmRoles(List.of("admin"));

//         // Get realm
//         RealmResource realmResource = keycloak.realm(realm);
//         UsersResource usersRessource = realmResource.users();

//         // Create user (requires manage-users role)
//         Response response = usersRessource.create(user);
//         System.out.printf("Repsonse: %s %s%n", response.getStatus(), response.getStatusInfo());
//         System.out.println(response.getLocation());
//         String userId = CreatedResponseUtil.getCreatedId(response);

//         System.out.printf("User created with userId: %s%n", userId);

//         // Define password credential
//         CredentialRepresentation passwordCred = new CredentialRepresentation();
//         passwordCred.setTemporary(false);
//         passwordCred.setType(CredentialRepresentation.PASSWORD);
//         passwordCred.setValue("test");

//         UserResource userResource = usersRessource.get(userId);

//         // Set password credential
//         userResource.resetPassword(passwordCred);

// //        // Get realm role "tester" (requires view-realm role)
//         RoleRepresentation testerRealmRole = realmResource.roles()//
//                 .get("admin").toRepresentation();
// //
// //        // Assign realm role tester to user
//         userResource.roles().realmLevel() //
//                 .add(Arrays.asList(testerRealmRole));
// //
// //        // Get client
//         ClientRepresentation app1Client = realmResource.clients() //
//                 .findByClientId("admin-cli").get(0);
// //
// //        // Get client level role (requires view-clients role)
//         RoleRepresentation userClientRole = realmResource.clients().get(app1Client.getId()) //
//                 .roles().get("admin").toRepresentation();
// //
// //        // Assign client level role to user
//         userResource.roles() //
//                 .clientLevel(app1Client.getId()).add(Arrays.asList(userClientRole));

//         // Send password reset E-Mail
//         // VERIFY_EMAIL, UPDATE_PROFILE, CONFIGURE_TOTP, UPDATE_PASSWORD, TERMS_AND_CONDITIONS
// //        usersRessource.get(userId).executeActionsEmail(Arrays.asList("UPDATE_PASSWORD"));

//         // Delete User
// //        userResource.remove();
//     }

       public static void main(String[] args) {
       String authServerUrl = "http://localhost:8280";
       String realm = "dev-keycloak";

       String adminClientId = "admin-cli";

       String adminClientSecret = "TzfTf6Tzb48qsc0YI1lfiJZLwQtf3wgk";

       Keycloak keycloak = KeycloakBuilder.builder() //
               .serverUrl(authServerUrl) //
               .realm(realm) //
               .grantType(OAuth2Constants.CLIENT_CREDENTIALS) //
               .clientId(adminClientId) //
               .clientSecret(adminClientSecret) //
               .build();

       UserRepresentation admin = new UserRepresentation();
       admin.setEmail("admin@gamil.gov.kh");
       admin.setEnabled(true);
       admin.setEmailVerified(Boolean.TRUE);
       admin.setUsername("admin");
       admin.setFirstName("big");
       admin.setLastName("smoke");
       admin.setRealmRoles(List.of("admin"));
       RealmResource realmResource = keycloak.realm(realm);
       UsersResource usersResource = realmResource.users();

       // Create user (requires manage-users role)
       Response response = usersResource.create(admin);
       System.out.printf("Response: %s %s%n", response.getStatus(), response.getStatusInfo());
       System.out.println(response.getLocation());
       String adminId = CreatedResponseUtil.getCreatedId(response);

       System.out.printf("User created with userId: %s%n", adminId);

       // Define password credential
       CredentialRepresentation passwordAdmin = new CredentialRepresentation();
       passwordAdmin.setTemporary(false);
       passwordAdmin.setType(CredentialRepresentation.PASSWORD);
       passwordAdmin.setValue("admin12345");

       UserResource adminResource = usersResource.get(adminId);

       // Set password credential
       adminResource.resetPassword(passwordAdmin);

       // Get realm role "tester" (requires view-realm role)
       RoleRepresentation testerRealmRole = realmResource.roles()//
               .get("admin").toRepresentation();
       // Assign realm role tester to user
       adminResource.roles().realmLevel() //
               .add(Collections.singletonList(testerRealmRole));
// user
       UserRepresentation user = new UserRepresentation();
       user.setEmail("user@gamil.gov.kh");
       user.setEnabled(true);
       user.setEmailVerified(Boolean.TRUE);
       user.setUsername("user");
       user.setFirstName("big");
       user.setLastName("smoke");
       user.setRealmRoles(List.of("user"));
       RealmResource realmResourceUser = keycloak.realm(realm);
       UsersResource usersResourceUser = realmResource.users();

       // Create user (requires manage-users role)
       Response responseUser = usersResource.create(user);
       System.out.printf("Response: %s %s%n", responseUser.getStatus(), responseUser.getStatusInfo());
       System.out.println(responseUser.getLocation());
       String userId = CreatedResponseUtil.getCreatedId(responseUser);

       System.out.printf("User created with userId: %s%n", userId);

       // Define password credential
       CredentialRepresentation passwordUser = new CredentialRepresentation();
       passwordUser.setTemporary(false);
       passwordUser.setType(CredentialRepresentation.PASSWORD);
       passwordUser.setValue("user12345");

       UserResource userResource = usersResource.get(userId);

       // Set password credential
       userResource.resetPassword(passwordUser);

       // Get realm role "tester" (requires view-realm role)
       RoleRepresentation testerRealmRoleUser = realmResource.roles()//
               .get("user").toRepresentation();
       // Assign realm role tester to user
       userResource.roles().realmLevel() //
               .add(Collections.singletonList(testerRealmRoleUser));
//editor
       UserRepresentation editor = new UserRepresentation();
       editor.setEmail("editor@gamil.gov.kh");
       editor.setEnabled(true);
       editor.setEmailVerified(Boolean.TRUE);
       editor.setUsername("editor");
       editor.setFirstName("big");
       editor.setLastName("smoke");
       editor.setRealmRoles(List.of("editor"));
       RealmResource realmResourceEditor = keycloak.realm(realm);
       UsersResource usersResourceEditor = realmResourceEditor.users();

       // Create user (requires manage-users role)
       Response responseEditor = usersResourceEditor.create(editor);
       System.out.printf("Response: %s %s%n", responseEditor.getStatus(), responseEditor.getStatusInfo());
       System.out.println(responseEditor.getLocation());
       String editorId = CreatedResponseUtil.getCreatedId(responseEditor);

       System.out.printf("editor created with userId: %s%n", editorId);

       // Define password credential
       CredentialRepresentation passwordEditor = new CredentialRepresentation();
       passwordEditor.setTemporary(false);
       passwordEditor.setType(CredentialRepresentation.PASSWORD);
       passwordEditor.setValue("editor12345");

       UserResource editorResource = usersResource.get(editorId);

       // Set password credential
       editorResource.resetPassword(passwordEditor);

       // Get realm role "tester" (requires view-realm role)
       RoleRepresentation testerRealmRoleEditor = realmResource.roles()//
               .get("editor").toRepresentation();
       // Assign realm role tester to user
       editorResource.roles().realmLevel() //
               .add(Collections.singletonList(testerRealmRoleEditor));
   }
}
