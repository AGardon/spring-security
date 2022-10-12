// package com.xiaoyi.springsecurity.config;
//
// import com.xiaoyi.springsecurity.domain.Permission;
// import com.xiaoyi.springsecurity.service.UserService;
// import lombok.RequiredArgsConstructor;
// import org.springframework.context.annotation.Bean;
// import
// org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import
// org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.stereotype.Component;
//
// import java.util.List;
//
/// **
// * @author 王艺翔
// * @description SecurityConfig
// * @date 2022/10/9 12:52
// * @phone 18318436514
// * @email w2603494062@gmail.com
// * @github https://github.com/AGarden
// */
// @Component
// @EnableWebSecurity
// @RequiredArgsConstructor
// public class SecurityConfig {
//
//  private final PasswordEncoder passwordEncoder;
//  private final UserService userService;
//  private final UserDetailsService userDetailsService;
//
//  @Bean
//  UserDetailsService userDetailsService() {
//    //    InMemoryUserDetailsManager users = new InMemoryUserDetailsManager();
//    //    users.createUser(
//    //        User.withUsername("admin")
//    //            .password(passwordEncoder.encode("123456"))
//    //            .authorities("insert", "delete", "update", "show")
//    //            .build());
//    //    users.createUser(
//    //        User.withUsername("insert")
//    //            .password(passwordEncoder.encode("123456"))
//    //            .authorities("insert")
//    //            .build());
//    //    users.createUser(
//    //        User.withUsername("show")
//    //            .password(passwordEncoder.encode("123456"))
//    //            .authorities("show")
//    //            .build());
//    //    users.createUser(
//    //        User.withUsername("delete")
//    //            .password(passwordEncoder.encode("123456"))
//    //            .authorities("delete")
//    //            .build());
//    //    users.createUser(
//    //        User.withUsername("update")
//    //            .password(passwordEncoder.encode("123456"))
//    //            .authorities("update")
//    //            .build());
//    //    return users;
//    return new DaoAuthenticationConfigurer<>(userDetailsService)
//        .passwordEncoder(passwordEncoder)
//        .getUserDetailsService();
//  }
//
//  @Bean
//  SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//    //    return httpSecurity
//    //        .authorizeRequests()
//    //        .antMatchers("/**/addDemo")
//    //        .hasAnyAuthority("insert")
//    //        .antMatchers("/**/updateDemo")
//    //        .hasAnyAuthority("update")
//    //        .antMatchers("/**/deleteDemo")
//    //        .hasAnyAuthority("delete")
//    //        .antMatchers("/**/selectDemo")
//    //        .hasAnyAuthority("show")
//    //        .antMatchers("/login")
//    //        .permitAll()
//    //        .antMatchers("/**")
//    //        .fullyAuthenticated()
//    //        .and()
//    //        // .httpBasic()
//    //        .formLogin()
//    //        .loginPage("/login")
//    //        .and()
//    //        .csrf()
//    //        .disable()
//    //        .build();
//    List<Permission> list = userService.findAllPermission();
//    ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry requests =
//        httpSecurity.authorizeRequests();
//    list.forEach(
//        permission -> {
//          requests.antMatchers(permission.getUrl()).hasAnyAuthority(permission.getPermTag());
//        });
//    return requests
//        .antMatchers("/login")
//        .permitAll()
//        // 设置自定义登录页面
//        .antMatchers("/**")
//        .fullyAuthenticated()
//        .and()
//        .formLogin()
//        .loginPage("/login")
//        .and()
//        .csrf()
//        .disable()
//        .build();
//  }
//
//  //  @Bean
//  //  public InMemoryUserDetailsManager userDetailsService() {
//  //    UserDetails user =
//  //        User.withDefaultPasswordEncoder()
//  //            .username("user")
//  //            .password("password")
//  //            .roles("USER")
//  //            .build();
//  //    return new InMemoryUserDetailsManager(user);
//  //  }
// }
