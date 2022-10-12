package com.xiaoyi.springsecurity.repo;

import com.xiaoyi.springsecurity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByUserName(String userName);
}
