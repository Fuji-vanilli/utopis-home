package fj.utopis.user.services;

import fj.utopis.user.DTO.UserRequest;
import fj.utopis.user.DTO.UserResponse;
import fj.utopis.user.entities.User;
import fj.utopis.user.mapper.UserMapper;
import fj.utopis.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

import static java.lang.String.format;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    private User mapOauth2AttributesToUser (Map<String, Object> attributes) {
        User user= new User();
        String sub= attributes.get("sub").toString();

        if (attributes.get("preferred_username") != null) {
            user.setUsername(attributes.get("preferred_username").toString());
        }
        if (attributes.get("given_name") != null) {
            user.setFirstname(attributes.get("given_name").toString());
        } else {
            user.setFirstname(attributes.get("name").toString());
        }
        if (attributes.get("family_name") != null) {
            user.setLastname(attributes.get("family_name").toString());
        }
        if (attributes.get("email") != null) {
            user.setEmail(attributes.get("email").toString());
        }
        if (attributes.get("picture") != null) {
            user.setImageUrl(attributes.get("picture").toString());
        }


        return user;
    }

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

        return null;
    }

}
