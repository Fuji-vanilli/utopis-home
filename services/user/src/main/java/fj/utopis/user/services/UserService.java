package fj.utopis.user.services;

import fj.utopis.user.DTO.UserRequest;
import fj.utopis.user.DTO.UserResponse;

public interface UserService {
    UserResponse create(UserRequest request);
}
