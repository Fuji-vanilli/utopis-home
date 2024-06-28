package fj.utopis.user.security;


import fj.utopis.user.entities.User;
import fj.utopis.user.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final AuthService authService;

    @Value("${spring.security.oauth2.resourceServer.jwt.issuer-uri}")
    private String issuerUri;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth-> auth.anyRequest().authenticated());

        httpSecurity
                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(oauth2-> oauth2.jwt(Customizer.withDefaults()));

        return httpSecurity.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return JwtDecoders.fromIssuerLocation(issuerUri);
    }
}
