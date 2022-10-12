package com.xiaoyi.springsecurity.repo;

import com.xiaoyi.springsecurity.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
  Permission findByPermName(String permName);
}
