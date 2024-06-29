package fj.utopis.user.services;

import fj.utopis.user.DTO.UserRequest;
import fj.utopis.user.DTO.UserResponse;
import fj.utopis.user.entities.User;
import fj.utopis.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AuthServiceUser implements AuthService {
    private final UserRepository repository;

    @Override
    public UserResponse create(UserRequest request) {
        return null;
    }

    @Override
    public void syncWithIdp(OAuth2User oAuth2User) {

    }

    @Override
    public UserResponse updateUser(UserRequest request) {
        return null;
    }

    @Override
    public UserResponse getAuthenticationUserFromSecurityContext() {

        return null;

    }
}
