package com.why.shopServer.permission.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 权限表实体类
 *
 * @author why
 * @create 2022-04-28 16:03
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "permission")
public class Permission {
    /** 主键id **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    /** 权限 **/
    @Column(name = "role")
    private String permission;

    /** 权限描述 **/
    @Column(name = "role_describe")
    private String desc;
}
