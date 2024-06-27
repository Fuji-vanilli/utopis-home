package fj.utopis.user.controller;


import fj.utopis.user.DTO.UserResponse;
import fj.utopis.user.services.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Objects;

import static fj.utopis.user.utils.Root.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT)
@CrossOrigin("*")
public class AuthResourceApi implements AuthResourceController {
    private final AuthService authService;
    private final ClientRegistration clientRegistration;

    public AuthResourceApi(AuthService authService, ClientRegistrationRepository registrationRepository) {
        this.authService= authService;
        this.clientRegistration = registrationRepository.findByRegistrationId("okta");
    }

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

    @Override
    public ResponseEntity<?> logout(HttpServletRequest request) {
        String issuerUri = clientRegistration.getProviderDetails().getIssuerUri();
        String originUrl = request.getHeader(HttpHeaders.ORIGIN);
        Object[] params= {issuerUri, clientRegistration.getClientId(), originUrl};

        String logoutUrl = MessageFormat.format("{0}v2/logout?client_id={1}&returnTo={2}", params);
        request.getSession().invalidate();

        return ResponseEntity.ok(Map.of("logoutUrl", logoutUrl));
    }
}
