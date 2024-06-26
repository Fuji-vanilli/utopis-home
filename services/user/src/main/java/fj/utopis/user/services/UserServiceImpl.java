package fj.utopis.user.services;

import fj.utopis.user.DTO.UserRequest;
import fj.utopis.user.DTO.UserResponse;
import fj.utopis.user.entities.User;
import fj.utopis.user.mapper.UserMapper;
import fj.utopis.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;

import static java.lang.String.format;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserResponse create(UserRequest request) {
        return null;
    }

    @Override
    public UserResponse updateUser(UserRequest request) {
        var userOptional= userRepository.findOneByEmail(request.email());
        if (userOptional.isEmpty()) {
            throw new UnsupportedOperationException(
                    format("there is no user with the email: %s", request.email())
            );
        }
        User user = userOptional.get();

        migrateUpdate(request, user);
        user.setLastModifiedDate(Instant.now());
        userRepository.save(user);

        return userMapper.mapToUserResponse(user);
    }

    private void migrateUpdate(UserRequest request, User user) {
        if (!request.firstname().isBlank()) {
            user.setFirstname(request.firstname());
        }
        if (!request.lastname().isBlank()) {
            user.setLastname(request.lastname());
        }
        if (!request.imageUrl().isBlank()) {
            user.setImageUrl(request.imageUrl());
        }
    }

    public void syncWithIdp(OAuth2User oAuth2User) {
        Map<String, Object> attributes = oAuth2User.getAttributes();
        UserRequest request = mapOauth2AttributesToUser(attributes);
        Optional<User> existingUser = userRepository.findOneByEmail(request.email());
        if (existingUser.isPresent()) {
            if (attributes.get("updated_at") != null) {
                Instant dbLastModifiedDate = existingUser.orElseThrow().getLastModifiedDate();
                Instant idpModifiedDate;
                if(attributes.get("updated_at") instanceof Instant) {
                    idpModifiedDate = (Instant) attributes.get("updated_at");
                } else {
                    idpModifiedDate = Instant.ofEpochSecond((Integer) attributes.get("updated_at"));
                }
                if(idpModifiedDate.isAfter(dbLastModifiedDate)) {
                    updateUser(request);
                }
            }
        } else {
            userRepository.save(userMapper.mapToUser(request));
        }
    }

    public User getAuthenticationUserFromSecurityContext() {
        OAuth2User principal = (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserRequest request = mapOauth2AttributesToUser(principal.getAttributes());

        return userMapper.mapToUser(request);
    }

    private UserRequest mapOauth2AttributesToUser (Map<String, Object> attributes) {
        String username= null;
        String firstname= null;
        String lastname= null;
        String email= null;
        String imageUrl= null;

        if (attributes.get("preferred_username") != null) {
            username= attributes.get("preferred_username").toString();
        }
        if (attributes.get("given_name") != null) {
            firstname= attributes.get("given_name").toString();
        } else {
            firstname= attributes.get("name").toString();
        }
        if (attributes.get("family_name") != null) {
            lastname= attributes.get("family_name").toString();
        }
        if (attributes.get("email") != null) {
            email= attributes.get("email").toString();
        }
        if (attributes.get("picture") != null) {
            imageUrl= attributes.get("picture").toString();
        }

        return new UserRequest(
                username,
                firstname,
                lastname,
                email,
                imageUrl
        );
    }


}
