package com.kretsev.test_task.user.repository;

import com.kretsev.test_task.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
