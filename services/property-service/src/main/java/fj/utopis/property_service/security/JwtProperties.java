package fj.utopis.property_service.security;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jwt.oauth2")
@Getter @Setter
public class JwtProperties {
    private String resourceId;
    private String principalAttribute;
}
