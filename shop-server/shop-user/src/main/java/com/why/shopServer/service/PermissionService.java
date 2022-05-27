package com.why.shopServer.service;

import com.why.shopServer.permission.pojo.Permission;

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

    /**
     * 更新或保存角色
     * @param permission
     */
    void updatePermission(Permission permission);

    /**
     * 删除角色
     * @param id
     */
    void deletePermission(Integer id);
}
