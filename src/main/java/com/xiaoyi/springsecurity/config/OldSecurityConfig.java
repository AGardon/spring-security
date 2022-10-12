package com.xiaoyi.springsecurity.config;

import com.xiaoyi.springsecurity.domain.Permission;
import com.xiaoyi.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/**
 * @author 王艺翔
 * @description OldSecurityConfig
 * @date 2022/10/11 12:23
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github https://github.com/AGarden
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class OldSecurityConfig extends WebSecurityConfigurerAdapter {

  private final PasswordEncoder passwordEncoder;
  private final UserService userService;
  private final UserDetailsService userDetailsService;

  /**
   * 新增Security 授权的账户
   *
   * @param auth
   * @throws Exception
   */
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry
        authorizeRequests = http.authorizeRequests();
    // 1.需要查询到所有的权限
    List<Permission> allPermission = userService.findAllPermission();
    allPermission.forEach(
        (p -> {
          // 将该规则添加
          authorizeRequests.antMatchers(p.getUrl()).hasAnyAuthority(p.getPermTag());
        }));
    //
    // 可以允许login 不被拦截
    authorizeRequests
        .antMatchers("/login")
        .permitAll()
        // 设置自定义登录页面
        .antMatchers("/**")
        .fullyAuthenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .and()
        .csrf()
        .disable();
  }
}
