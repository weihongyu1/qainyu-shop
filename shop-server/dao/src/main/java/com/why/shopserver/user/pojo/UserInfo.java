package com.why.shopserver.user.pojo;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户信息表实体类
 *
 * @author why
 * @create 2022-04-21 14:09
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity //标记实体类
@Table(name = "user_info") //映射数据库中的表 ,如果开了正向索引就会创建此表
public class UserInfo implements Serializable {
    /** 主键id **/
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    /** 电话号码 **/
    @Column(name="phone_number")
    private String phoneNumber;

    /** 邮件地址 **/
    @Column(name="email")
    private String email;

    /** 家庭住址 **/
    @Column(name="address")
    private String address;

    /** 外键，用户登录表id **/
    @JoinColumn(name="u_id") //维护外键
    private Integer uId;
}