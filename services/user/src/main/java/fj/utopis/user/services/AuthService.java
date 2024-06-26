package fj.utopis.user.services;

import fj.utopis.user.DTO.UserRequest;
import fj.utopis.user.DTO.UserResponse;
import org.springframework.security.oauth2.core.user.OAuth2User;

public interface AuthService {
    UserResponse create(UserRequest request);
    void syncWithIdp(OAuth2User oAuth2User);
    UserResponse updateUser(UserRequest request);
    UserResponse getAuthenticationUserFromSecurityContext();
}
