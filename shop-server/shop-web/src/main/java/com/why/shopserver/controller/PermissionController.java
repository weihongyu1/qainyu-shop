package com.why.shopServer.controller;

import com.why.shopServer.commonenum.StatusEnum;
import com.why.shopServer.permission.pojo.Permission;
import com.why.shopServer.service.impl.PermissionServiceImpl;
import com.why.shopServer.vo.ResultVo;
import io.lettuce.core.dynamic.annotation.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 权限数据接口
 *
 * @author why
 * @create 2022-04-28 16:16
 **/
@Slf4j
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

    @PostMapping("/update")
    public ResultVo updateRole(@RequestBody Permission permission){
        permissionService.updatePermission(permission);
        return ResultVo.success(StatusEnum.USER_PERMISSION_UPDATE_SUCCESS);
    }

    @DeleteMapping("/delete")
    public ResultVo deleteRole(@Param("id") Integer id){
        permissionService.deletePermission(id);
        return ResultVo.success(StatusEnum.USER_PERMISSION_UPDATE_SUCCESS);
    }
}
