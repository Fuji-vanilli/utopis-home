package fj.utopis.user.services;

import fj.utopis.user.DTO.UserRequest;
import fj.utopis.user.DTO.UserResponse;
import fj.utopis.user.mapper.UserMapper;
import fj.utopis.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
