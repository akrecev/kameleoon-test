package com.kretsev.test_task.user.mapper;

import com.kretsev.test_task.user.dto.NewUserRequest;
import com.kretsev.test_task.user.dto.UserDto;
import com.kretsev.test_task.user.dto.UserShortDto;
import com.kretsev.test_task.user.model.User;

import java.time.LocalDateTime;

public class UserMapper {
    private UserMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static UserDto toUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreated()
        );
    }

    public static UserShortDto toUserShortDto(User user) {
        return new UserShortDto(
                user.getName()
        );
    }

    public static User toNewUser(NewUserRequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .created(LocalDateTime.now())
                .build();
    }

}
