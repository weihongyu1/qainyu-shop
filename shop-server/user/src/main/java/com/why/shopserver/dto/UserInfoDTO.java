package com.why.shopserver.dto;

import com.why.shopserver.user.pojo.UserInfo;
import com.why.shopserver.user.pojo.UserLogin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

/**
 * 用户登录信息和用户基础信息
 *
 * @author why
 * @create 2022-04-26 15:50
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO {
    private Integer id;
    private String username;
    private String[] roles;
}