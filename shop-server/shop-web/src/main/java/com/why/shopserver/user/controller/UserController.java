package com.why.shopserver.user.controller;

import cn.hutool.log.Log;
import com.why.shopserver.commonenum.StatusEnum;
import com.why.shopserver.service.impl.UserServiceBaseImpl;
import com.why.shopserver.user.pojo.UserInfo;
import com.why.shopserver.user.pojo.UserLogin;
import com.why.shopserver.util.JwtUtil;
import com.why.shopserver.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户信息数据接口
 *
 * @author why
 * @create 2022-04-26 16:05
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserServiceBaseImpl userServiceBase;
    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 修改用户登录信息
     * @param userLogin
     * @return
     */
    @PostMapping("/update_login")
    public ResultVo updateUserLogin(@RequestBody UserLogin userLogin){
        userServiceBase.updateUserLogin(userLogin);
        return ResultVo.success(StatusEnum.USER_LOGIN_UPDATE_SUCCESS);
    }

    /**
     * 更新或保存用户信息
     * @param userInfo
     * @return
     */
    @PostMapping("/update_info")
    public ResultVo updateUserInfo(@RequestBody UserInfo userInfo){
        if (userServiceBase.updateUserInfo(userInfo)){
            return ResultVo.success(StatusEnum.USER_INFO_UPDATE_SUCCESS);
        } else {
            return ResultVo.error(StatusEnum.USER_INFO_UPDATE_ERROR);
        }

    }

    /**
     * 获取用户信息
     * @param request
     * @return
     */
    @GetMapping("/get_user")
    public ResultVo getUserInfo(HttpServletRequest request){
        return ResultVo.success(
                StatusEnum.USER_INFO_GET_SUCCESS,
                userServiceBase.getUserInfo(jwtUtil.getUserNameFromToken(jwtUtil.getToken(request)))
        );
    }
}
