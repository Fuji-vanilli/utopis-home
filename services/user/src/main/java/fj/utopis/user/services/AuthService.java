package fj.utopis.user.services;

import fj.utopis.user.DTO.UserRequest;
import fj.utopis.user.DTO.UserResponse;
import fj.utopis.user.entities.User;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;

public interface AuthService {
    User createUserFromOAuth2Login(OAuth2AuthenticationToken authentication);
    UserResponse create(UserRequest request);
    void syncWithIdp(OAuth2User oAuth2User);
    UserResponse updateUser(UserRequest request);
    UserResponse getAuthenticationUserFromSecurityContext();
}
