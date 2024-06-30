package fj.utopis.user.controller;

import fj.utopis.user.DTO.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;

public interface AuthResourceController {
    @GetMapping("/register-user")
    ResponseEntity<UserResponse> registerUserFromOAuth2(Authentication authentication);
    @GetMapping("/get-authenticated-user")
    ResponseEntity<UserResponse> getAuthenticatedUser();
}
