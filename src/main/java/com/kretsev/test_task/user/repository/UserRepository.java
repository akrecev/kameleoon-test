package com.kretsev.test_task.user.repository;

import com.kretsev.test_task.user.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findByIdIn(Collection<Long> ids, Pageable pageable);

}
