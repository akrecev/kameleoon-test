package com.kretsev.test_task.user.service.impl;

import com.kretsev.test_task.exception.DataNotFoundException;
import com.kretsev.test_task.user.dto.NewUserRequest;
import com.kretsev.test_task.user.dto.UserDto;
import com.kretsev.test_task.user.mapper.UserMapper;
import com.kretsev.test_task.user.model.User;
import com.kretsev.test_task.user.repository.UserRepository;
import com.kretsev.test_task.user.service.UserService;
import com.kretsev.test_task.utility.MyPageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    public UserDto getUser(Long userId) {
        return toUserDto(userRepository.findById(userId).orElseThrow(() -> new DataNotFoundException("User", userId)));
    }

    @Override
    public List<UserDto> getUsers(List<Long> ids, Integer from, Integer size) {
        return userRepository.findByIdIn(ids, new MyPageRequest(from, size))
                .stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteById(Long userId) {
        userRepository.findById(userId).orElseThrow(() -> new DataNotFoundException("User", userId));
        userRepository.deleteById(userId);
    }
}

