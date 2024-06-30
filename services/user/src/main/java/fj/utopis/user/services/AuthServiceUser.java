package fj.utopis.user.services;

import fj.utopis.user.DTO.UserRequest;
import fj.utopis.user.DTO.UserResponse;
import fj.utopis.user.entities.User;
import fj.utopis.user.exception.UserNotFoundException;
import fj.utopis.user.mapper.UserMapper;
import fj.utopis.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static java.lang.String.format;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AuthServiceUser implements AuthService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserResponse registerUserFromOAuth2(Authentication authentication) {
        Map<String, Object> tokenAttributes= Map.of();
        if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
            tokenAttributes = jwtAuthenticationToken.getTokenAttributes();
        }
        final String email= tokenAttributes.get("email").toString();
        Optional<User> userOptional= userRepository.findOneByEmail(email);

        if (userOptional.isPresent()) {
            log.error("User {} already exists", email);
            throw new UserNotFoundException(
                    format("User with email %s already exists", email)
            );
        }
        User user= User.builder()
                .username(tokenAttributes.get("preferred_username").toString())
                .firstname(tokenAttributes.get("given_name").toString())
                .lastname(tokenAttributes.get("family_name").toString())
                .email(email)
                .build();

        user.setId(UUID.randomUUID().toString());
        user.setCreatedDate(Instant.now());
        user.setLastModifiedDate(Instant.now());

        log.info("new user created successfully from Oauth2");

        userRepository.save(user);
        return userMapper.mapToUserResponse(user);
    }
}
