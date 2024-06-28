package fj.utopis.user.controller;


import fj.utopis.user.DTO.UserResponse;
import fj.utopis.user.services.AuthService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static fj.utopis.user.utils.Root.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT)
@RequiredArgsConstructor
public class AuthResourceApi implements AuthResourceController {
    private final AuthService authService;


    @GetMapping("/")
    public ResponseEntity<String> home(@AuthenticationPrincipal OAuth2User principal) {
        return ResponseEntity.ok(principal.getAttribute("email"));
    }

    @GetMapping("/test")
    public String getTest() {
        return "Test is successfully";
    }

    @Override
    public ResponseEntity<UserResponse> getAuthenticatedUser(OAuth2User user) {
        if (Objects.isNull(user)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        authService.syncWithIdp(user);
        UserResponse userAuthenticated = authService.getAuthenticationUserFromSecurityContext();

        return ResponseEntity.ok(userAuthenticated);
    }

}
