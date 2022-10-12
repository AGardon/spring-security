package com.xiaoyi.springsecurity.api;

import com.xiaoyi.springsecurity.domain.User;
import com.xiaoyi.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王艺翔
 * @description UserApi
 * @date 2022/10/10 15:19
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github https://github.com/AGarden
 */
@RestController
@RequestMapping("/api/v2/user")
@Slf4j
@RequiredArgsConstructor
public class UserApi {

  private final UserService userService;

  /**
   * 根据用户名称获取用户信息
   *
   * @param userName
   * @return
   */
  @GetMapping("/getUser")
  public ResponseEntity<User> getUser(String userName) {
    return ResponseEntity.ok().body(userService.getByUserName(userName));
  }
}
