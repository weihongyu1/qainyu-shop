package com.why.shopserver.user.controller;

import com.why.shopserver.commonenum.StatusEnum;
import com.why.shopserver.permission.pojo.Permission;
import com.why.shopserver.service.impl.PermissionServiceImpl;
import com.why.shopserver.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 权限数据接口
 *
 * @author why
 * @create 2022-04-28 16:16
 **/
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionServiceImpl permissionService;

    /**
     * 获取所有的权限接口
     * @return
     */
    @GetMapping("/get_all")
    public ResultVo getAllPermission(){
        return ResultVo.success(StatusEnum.USER_PERMISSION_GET_ALL_SUCCESS, permissionService.findAllPermission());
    }
}