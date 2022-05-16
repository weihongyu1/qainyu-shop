package com.why.shopserver.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户传输实体
 *
 * @author why
 * @create 2022-05-15 14:12
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserListVo {
    private Integer userId;
    private String username;
    private String address;
    private String phoneNumber;
    private String loginStatus;
    private String role;
    private String date;
    private String introduction;
}
