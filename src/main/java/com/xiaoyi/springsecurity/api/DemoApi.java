package com.xiaoyi.springsecurity.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王艺翔
 * @description UserApi
 * @date 2022/10/7 14:39
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github https://github.com/AGarden
 */
@RestController
@Slf4j
@RequestMapping("api/v1")
public class DemoApi {

  @GetMapping("/addDemo")
  public String addDemo() {
    return "添加接口";
  }

  @GetMapping("/updateDemo")
  public String updateDemo() {
    return "修改接口";
  }

  @GetMapping("/deleteDemo")
  public String deleteDemo() {
    return "删除接口";
  }

  @GetMapping("/selectDemo")
  public String selectDemo() {
    return "查询接口";
  }
}
