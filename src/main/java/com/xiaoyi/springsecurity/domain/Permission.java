package com.xiaoyi.springsecurity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author 王艺翔
 * @description Permission
 * @date 2022/10/7 14:05
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github https://github.com/AGarden
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String permName;
  // 权限标识
  private String permTag;
  // 请求url
  private String url;
}
