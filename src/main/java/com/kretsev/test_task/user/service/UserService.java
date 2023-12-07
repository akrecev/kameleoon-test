package com.kretsev.test_task.user.service;

import com.kretsev.test_task.user.dto.NewUserRequest;
import com.kretsev.test_task.user.dto.UserDto;

public interface UserService {
    UserDto create(NewUserRequest newUserRequest);
}
