package fj.utopis.user.controller;


import fj.utopis.user.DTO.UserResponse;
import fj.utopis.user.services.AuthService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static fj.utopis.user.utils.Root.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT)
@RequiredArgsConstructor
public class AuthResourceApi implements AuthResourceController {
    private final AuthService authService;

    @GetMapping("/auth-resource")
    public Authentication getAuth(Authentication authentication) {
        return authentication;
    }

    @Override
    public ResponseEntity<UserResponse> registerUserFromOAuth2(Authentication authentication) {
        return ResponseEntity.ok(authService.registerUserFromOAuth2(authentication));
    }

}
