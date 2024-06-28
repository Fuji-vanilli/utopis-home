package fj.utopis.gateway_service.config;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class GatewayController {

    @GetMapping("/login")
    public ResponseEntity<Object> login(
            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,
            @AuthenticationPrincipal OidcUser user) {
        String tokenValue= "nothing connected";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(client.getAccessToken().getTokenValue());
    }
}
