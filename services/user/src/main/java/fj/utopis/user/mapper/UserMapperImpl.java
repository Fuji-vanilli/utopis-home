package fj.utopis.user.mapper;

import fj.utopis.user.DTO.UserRequest;
import fj.utopis.user.DTO.UserResponse;
import fj.utopis.user.entities.User;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserMapperImpl implements UserMapper{
    @Override
    public User mapToUser(UserRequest request) {
        return User.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .username(request.username())
                .imageUrl(request.imageUrl())
                .build();
    }

    @Override
    public UserResponse mapToUserResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getImageUrl(),
                user.getCreatedDate(),
                user.getLastModifiedDate()
        );
    }
}
