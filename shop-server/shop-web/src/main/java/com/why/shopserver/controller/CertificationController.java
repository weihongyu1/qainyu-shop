package com.why.shopServer.controller;

import cn.hutool.core.util.StrUtil;
import com.why.shopServer.commonenum.StatusEnum;
import com.why.shopServer.vo.ResultVo;
import com.why.shopServer.vo.UserLoginVo;
import com.why.shopServer.vo.UserRegisterVo;
import com.why.shopserver.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 认证接口
 *
 * @author why
 * @create 2022-04-22 17:32
 **/
@RestController
@RequestMapping("/auths")
@Slf4j
public class CertificationController {
    @Autowired
    private UserServiceImpl userService;

    /**
     * 登录接口
     * @param userLogin
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/login")
    public ResultVo login(@RequestBody UserLoginVo userLogin) throws Exception {
        if (StrUtil.isEmpty(userLogin.getUsername()) || (StrUtil.isEmpty(userLogin.getPassword()))) {
            return ResultVo.error(StatusEnum.USERNAME_OR_PASSWORD_NULL);
        }
        try{
            Map<String,String> map = new HashMap<>();
            map.put("token", userService.login(userLogin.getUsername(), userLogin.getPassword()));
            return ResultVo.success(StatusEnum.CERTIFICATION_SUCCESS, map);
        }catch(Exception e){
            return ResultVo.error(e.getMessage());
        }
    }

    /**
     * 用户注册
     * @param userRegister
     * @return
     */
    @PostMapping("/register")
    public ResultVo register(@RequestBody UserRegisterVo userRegister){
        userService.register(userRegister.getUsername(), userRegister.getPassword(), userRegister.getAuths());
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
