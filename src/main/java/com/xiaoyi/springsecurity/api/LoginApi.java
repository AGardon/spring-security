package com.xiaoyi.springsecurity.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 王艺翔
 * @description LoginApi
 * @date 2022/10/9 20:13
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github https://github.com/AGarden
 */
@Controller
public class LoginApi {

  @RequestMapping("/login")
  public String login() {
    return "login";
  }
}
