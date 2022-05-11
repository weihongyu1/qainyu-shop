package com.why.shopserver.service;

import com.why.shopserver.dto.UserInfoDTO;
import com.why.shopserver.user.pojo.UserInfo;
import com.why.shopserver.user.pojo.UserLogin;

/**
 * @InterfaceName：UserService
 * @Description：用户业务接口
 * @Author: why
 * @create 2022-04-26 15:46
 **/
public interface UserServiceBase {

    /**
     * 修改用户登录信息
     * @param userLogin
     */
    void updateUserLogin(UserLogin userLogin);

    /**
     * 修改用户基础信息
     * @param userInfo
     */
    boolean updateUserInfo(UserInfo userInfo);

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    UserInfoDTO getUserInfo(String username);
}
