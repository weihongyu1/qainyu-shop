package com.why.shopServer.controller;

import com.why.shopServer.commonenum.StatusEnum;
import com.why.shopServer.service.impl.UserServiceBaseImpl;
import com.why.shopServer.user.pojo.UserLogin;
import com.why.shopServer.util.JwtUtil;
import com.why.shopServer.vo.ResultVo;
import com.why.shopServer.vo.UserListVo;
import io.lettuce.core.dynamic.annotation.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @param userListVo
     * @return
     */
    @PostMapping("/update_info")
    public ResultVo updateUserInfo(@RequestBody UserListVo userListVo){
        log.info(userListVo.toString());
        if (userServiceBase.updateUserInfo(userListVo)){
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

    /**
     * 获取所有用户信息
     * @return
     */
    @GetMapping("/get_all")
    public ResultVo getAllUser(){
        return ResultVo.success(
                StatusEnum.USER_GET_ALL_SUCCESS,
                userServiceBase.getUserList()
        );
    }

    /**
     * 删除用户
     * @param uId
     * @return
     */
    @GetMapping("/del")
    public ResultVo deleteUser(@Param("uId") Integer uId){
        log.info(String.valueOf(uId));
        userServiceBase.delUser(uId);
        return ResultVo.success(StatusEnum.USER_DELETE_SUCCESS);
    }
}
