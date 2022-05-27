package com.why.shopServer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String name;
    private String[] roles;
    private String introduction;
    private String avatar;
}
