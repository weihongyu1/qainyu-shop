package com.why.shopserver.service;

import com.why.shopserver.permission.pojo.Permission;

import java.util.List;

/**
 * @InterfaceName：PermissionService
 * @Description：
 * @Author: why
 * @create 2022-04-28 16:10
 **/
public interface PermissionService {

    /**
     * 查询所有权限
     * @return
     */
    List<Permission> findAllPermission();
}
