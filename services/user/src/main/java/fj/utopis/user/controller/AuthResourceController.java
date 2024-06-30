package fj.utopis.user.controller;

import fj.utopis.user.DTO.UserResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface AuthResourceController {
    @GetMapping("/get-authenticated-user")
    ResponseEntity<UserResponse> registerUserFromOAuth2(Authentication authentication);
}
