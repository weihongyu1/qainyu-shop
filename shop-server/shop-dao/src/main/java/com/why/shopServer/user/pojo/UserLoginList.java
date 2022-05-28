package com.why.shopServer.user.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 已登录用户列表
 *
 * @author why
 * @create 2022-05-15 14:43
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //标记实体类
@Table(name = "user_login_list")
public class UserLoginList {

    /** 主键id **/
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //主键生成策略 , 此策略为数据库自动生成 (自动增长)
    @Column(name = "id")
    private Integer id;

    /** 登录id **/
    @Column(name = "u_id")
    private Integer uId;

    /** 登录时间 **/
    @Column(name = "login_time")
    private Date loginTime;
}
