package fj.utopis.user.mapper;

import fj.utopis.user.DTO.UserRequest;
import fj.utopis.user.DTO.UserResponse;
import fj.utopis.user.entities.User;

public interface UserMapper {
    User mapToUser(UserRequest request);
    UserResponse mapToUserResponse(User user);
}
