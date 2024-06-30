package fj.utopis.user.services;


import fj.utopis.user.DTO.UserResponse;
import org.springframework.security.core.Authentication;

public interface AuthService {
    UserResponse registerUserFromOAuth2(Authentication authentication);
    UserResponse getCurrentUserConnected();
}
