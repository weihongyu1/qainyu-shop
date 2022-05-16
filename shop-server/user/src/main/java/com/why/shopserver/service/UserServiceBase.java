package com.why.shopserver.service;

import com.why.shopserver.dto.UserInfoDTO;
import com.why.shopserver.user.pojo.UserInfo;
import com.why.shopserver.user.pojo.UserLogin;
import com.why.shopserver.user.pojo.UserLoginList;
import com.why.shopserver.vo.UserListVo;
import com.why.shopserver.vo.UserLoginVo;

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
