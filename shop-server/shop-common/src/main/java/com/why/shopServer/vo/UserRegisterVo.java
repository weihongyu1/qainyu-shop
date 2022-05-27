package com.why.shopServer.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户注册实体类
 *
 * @author why
 * @create 2022-04-25 20:24
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterVo {
    private String username;
    private String password;
    private String auths;
}
