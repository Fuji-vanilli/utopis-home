package fj.utopis.user.controller;

import fj.utopis.user.DTO.UserResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface AuthResourceController {
    @GetMapping("/get-authenticated-user")
    ResponseEntity<UserResponse> getAuthenticatedUser(
            @AuthenticationPrincipal OAuth2User user
    );
    @PostMapping("/logout")
    ResponseEntity<?> logout(HttpServletRequest request);
}
