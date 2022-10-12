package com.xiaoyi.springsecurity;

// import com.xiaoyi.springsecurity.domain.Permission;
// import com.xiaoyi.springsecurity.domain.Role;
// import com.xiaoyi.springsecurity.domain.User;
// import com.xiaoyi.springsecurity.service.UserService;
// import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringSecurityApplication.class, args);
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  //    @Bean
  //    CommandLineRunner run(UserService userService) {
  //      return args -> {
  //        // 保存权限
  //        userService.savePerm(new Permission(null, "查询", "select", "/selectDemo"));
  //        userService.savePerm(new Permission(null, "修改", "update", "/updateDemo"));
  //        userService.savePerm(new Permission(null, "添加", "add", "/addDemo"));
  //        userService.savePerm(new Permission(null, "删除", "delete", "/deleteDemo"));
  //        // 保存角色
  //        userService.saveRole(new Role(null, "管理人", new ArrayList<>()));
  //        userService.saveRole(new Role(null, "经理人", new ArrayList<>()));
  //        userService.saveRole(new Role(null, "法务人", new ArrayList<>()));
  //        userService.saveRole(new Role(null, "其他人", new ArrayList<>()));
  //        // 保存用户
  //        userService.saveUser(
  //            new User(null, "zhangsan", "张三", "123456", "zhangsan@gmail.com", new
  // ArrayList<>()));
  //        userService.saveUser(
  //            new User(null, "lisi", "李四", "123456", "lisi@gmail.com", new ArrayList<>()));
  //        userService.saveUser(
  //            new User(null, "wangwu", "王五", "123456", "wangwu@gmail.com", new ArrayList<>()));
  //        userService.saveUser(
  //            new User(null, "zhaoliu", "赵六", "123456", "zhaoliu@gmail.com", new ArrayList<>()));
  //        // 将权限赋予角色
  //        userService.savePermToRole("管理人", "查询");
  //        userService.savePermToRole("管理人", "修改");
  //        userService.savePermToRole("管理人", "添加");
  //        userService.savePermToRole("管理人", "删除");
  //        userService.savePermToRole("经理人", "查询");
  //        userService.savePermToRole("经理人", "修改");
  //        userService.savePermToRole("经理人", "删除");
  //        userService.savePermToRole("法务人", "添加");
  //        userService.savePermToRole("法务人", "查询");
  //        userService.savePermToRole("其他人", "查询");
  //        // 将角色赋予用户
  //        userService.saveRoleToUser("zhangsan", "管理人");
  //        userService.saveRoleToUser("lisi", "经理人");
  //        userService.saveRoleToUser("wangwu", "法务人");
  //        userService.saveRoleToUser("wangwu", "经理人");
  //        userService.saveRoleToUser("zhaoliu", "其他人");
  //      };
  //    }
}
