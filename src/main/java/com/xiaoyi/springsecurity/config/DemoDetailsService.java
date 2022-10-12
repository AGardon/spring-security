package com.xiaoyi.springsecurity.config;

import com.xiaoyi.springsecurity.domain.Role;
import com.xiaoyi.springsecurity.domain.User;
import com.xiaoyi.springsecurity.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 王艺翔
 * @description DemoDetailsService
 * @date 2022/10/10 22:03
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github https://github.com/AGarden
 */
@Component
@RequiredArgsConstructor
public class DemoDetailsService implements UserDetailsService {

  private final UserRepository userRepository;
  /**
   * 获取用户权限
   *
   * @param username the username identifying the user whose data is required.
   * @return userDetails
   * @throws UsernameNotFoundException
   */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUserName(username);
    assert user != null;
    Set<SimpleGrantedAuthority> set = new HashSet<>();
    Collection<Role> roles = user.getRoles();
    roles.forEach(
        role -> {
          role.getPerms()
              .forEach(
                  permission -> {
                    set.add(new SimpleGrantedAuthority(permission.getPermTag()));
                  });
        });
    return new org.springframework.security.core.userdetails.User(
        user.getUserName(), user.getPassword(), set);
  }
}
