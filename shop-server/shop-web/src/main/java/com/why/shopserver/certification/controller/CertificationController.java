package com.why.shopserver.certification.controller;

import cn.hutool.core.util.StrUtil;
import com.why.shopserver.StatusEnum;
import com.why.shopserver.service.impl.UserServiceImpl;
import com.why.shopserver.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * 认证接口
 *
 * @author why
 * @create 2022-04-22 17:32
 **/
@RestController
@RequestMapping("/auths")
public class CertificationController {
    @Autowired
    private UserServiceImpl userService;
    private final String USERNAME = "username";
    private final String PASSWORD = "password";

    /**
     * 登录接口
     * @param map
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/login")
    public ResultVo login(@RequestBody Map<String, String> map) throws Exception {
        String username = map.get(USERNAME);
        String password = map.get(PASSWORD);
        if (StrUtil.isEmpty(username) || (StrUtil.isEmpty(password))) {
            return ResultVo.error(StatusEnum.USERNAME_OR_PASSWORD_NULL);
        }
        try{
            return ResultVo.success(StatusEnum.CERTIFICATION_SUCCESS,userService.login(username, password));
        }catch(Exception e){
            return ResultVo.error(e.getMessage());
        }
    }

    /**
     * 用户注册
     * @param username 用户名
     * @param password 密码
     * @param auths 权限
     * @return
     */
    @PostMapping("/register")
    public ResultVo register(String username, String password, String auths){
        userService.register(username,password,auths);
        return ResultVo.success(StatusEnum.REGISTER_SUCCESS);
    }

    /**
     * 刷新令牌
     * @param token
     * @return
     */
    @PostMapping(value = "/refresh_token")
    public ResultVo refresh(@RequestHeader("${jwt.header}") String token) {
        return ResultVo.success(StatusEnum.REFRESH_TOKEN_SUCCESS, userService.refreshToken(token));
    }
}