package com.why.shopServer.service;

import com.why.shopServer.dto.UserInfoDTO;
import com.why.shopServer.user.pojo.UserLogin;
import com.why.shopServer.vo.UserListVo;

import java.util.List;

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
     * @param userListVo
     */
    boolean updateUserInfo(UserListVo userListVo);

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    UserInfoDTO getUserInfo(String username);

    /**
     * 获取用户列表
     * @return
     */
    List<UserListVo> getUserList();

    /**
     * 删除用户
     * @param uId
     */
    void delUser(Integer uId);
}
