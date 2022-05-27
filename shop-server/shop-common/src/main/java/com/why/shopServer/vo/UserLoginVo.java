package com.why.shopServer.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户登录实体
 *
 * @author why
 * @create 2022-04-25 20:01
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginVo {
    private String username;
    private String password;
}
