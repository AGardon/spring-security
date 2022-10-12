package com.xiaoyi.springsecurity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author ������
 * @description Role
 * @date 2022/10/7 13:59
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github https://github.com/AGarden
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String roleName;

  @ManyToMany(fetch = FetchType.EAGER)
  private Collection<Permission> Perms = new ArrayList<>();
}
