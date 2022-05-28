package com.why.shopServer.service;

/**
 * @InterfaceName：UserService
 * @Description： 用户登录，注册业务接口
 * @Author: why
 * @create 2022-04-22 17:20
 **/
public interface UserService {
    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 注册功能
     * @param username 用户名
     * @param password 密码
     */
    void register(String username, String password, String auths);

    /**
     * 刷新Token
     * @param oldToken
     * @return
     */
    String refreshToken(String oldToken);
}
