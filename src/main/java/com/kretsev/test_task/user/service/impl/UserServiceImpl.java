package com.kretsev.test_task.user.service.impl;

import com.kretsev.test_task.user.dto.NewUserRequest;
import com.kretsev.test_task.user.dto.UserDto;
import com.kretsev.test_task.user.model.User;
import com.kretsev.test_task.user.repository.UserRepository;
import com.kretsev.test_task.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.kretsev.test_task.user.mapper.UserMapper.toNewUser;
import static com.kretsev.test_task.user.mapper.UserMapper.toUserDto;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDto create(NewUserRequest newUserRequest) {
        User user = userRepository.save(toNewUser(newUserRequest));

        return toUserDto(user);
    }
}

