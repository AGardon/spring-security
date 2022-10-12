package com.xiaoyi.springsecurity.exception;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王艺翔
 * @description ErrorException
 * @date 2022/10/9 19:24
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github https://github.com/AGarden
 */
@RestController
public class ErrorException {

  @RequestMapping("/error/403")
  public String error() {
    return "您当前访问的接口权限不足!";
  }
}
