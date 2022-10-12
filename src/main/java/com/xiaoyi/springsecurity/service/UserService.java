package com.xiaoyi.springsecurity.service;

import com.xiaoyi.springsecurity.domain.Permission;
import com.xiaoyi.springsecurity.domain.Role;
import com.xiaoyi.springsecurity.domain.User;

import java.util.List;

/**
 * @author 王艺翔
 * @description UserService
 * @date 2022/10/7 14:12
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github <a href="https://github.com/AGarden">...</a>
 */
public interface UserService {

  Permission savePerm(Permission permission);

  Role saveRole(Role role);

  User saveUser(User user);

  void saveRoleToUser(String userName, String roleName);

  void savePermToRole(String roleName, String permName);

  User getByUserName(String userName);

  List<Permission> findAllPermission();

  List<User> findAllUser();
}
