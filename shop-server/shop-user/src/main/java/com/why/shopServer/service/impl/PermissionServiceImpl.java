package com.why.shopServer.service.impl;

import com.why.shopServer.permission.pojo.Permission;
import com.why.shopServer.permission.repository.PermissionRepository;
import com.why.shopServer.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限业务接口实现类
 *
 * @author why
 * @create 2022-04-28 16:13
 **/
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<Permission> findAllPermission() {
        return permissionRepository.findAll();
    }

    @Override
    public void updatePermission(Permission permission) {
        permissionRepository.save(permission);
    }

    @Override
    public void deletePermission(Integer id) {
        permissionRepository.deleteById(id);
    }
}
