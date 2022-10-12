package com.xiaoyi.springsecurity.service.serviceImpl;

import com.xiaoyi.springsecurity.domain.Permission;
import com.xiaoyi.springsecurity.domain.Role;
import com.xiaoyi.springsecurity.domain.User;
import com.xiaoyi.springsecurity.repo.PermissionRepository;
import com.xiaoyi.springsecurity.repo.RoleRepository;
import com.xiaoyi.springsecurity.repo.UserRepository;
import com.xiaoyi.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 王艺翔
 * @description UserServiceImpl
 * @date 2022/10/7 14:14
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github https://github.com/AGarden
 */
@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PermissionRepository permRepository;
  private final PasswordEncoder passwordEncoder;

  /**
   * 保存权限
   *
   * @param permission 权限
   * @return 权限
   */
  @Override
  public Permission savePerm(Permission permission) {
    log.info("保存权限{}", permission.getPermName());
    return permRepository.save(permission);
  }

  /**
   * 保存角色
   *
   * @param role 角色
   * @return 角色
   */
  @Override
  public Role saveRole(Role role) {
    log.info("保存角色:{}", role.getRoleName());
    return roleRepository.save(role);
  }

  /**
   * 保存用户
   *
   * @param user 用户
   * @return 用户
   */
  @Override
  public User saveUser(User user) {
    log.info("保存用户{}", user.getUserName());
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }

  /**
   * 将角色赋予用户
   *
   * @param userName 用户名称
   * @param roleName 角色名称
   */
  @Override
  public void saveRoleToUser(String userName, String roleName) {
    log.info("将角色{}赋予用户{}", roleName, userName);
    User user = userRepository.findByUserName(userName);
    Role role = roleRepository.findByRoleName(roleName);
    user.getRoles().add(role);
  }

  /**
   * 将权限赋予角色
   *
   * @param roleName 角色名称
   * @param permName 权限名称
   */
  @Override
  public void savePermToRole(String roleName, String permName) {
    log.info("将权限{}赋予角色{}", permName, roleName);
    Role role = roleRepository.findByRoleName(roleName);
    Permission perm = permRepository.findByPermName(permName);
    role.getPerms().add(perm);
  }

  /**
   * 根据用户名称查询用户
   *
   * @param userName
   * @return
   */
  @Override
  public User getByUserName(String userName) {
    return userRepository.findByUserName(userName);
  }

  @Override
  public List<Permission> findAllPermission() {
    return permRepository.findAll();
  }

  @Override
  public List<User> findAllUser() {
    return userRepository.findAll();
  }
}
