package com.why.shopserver.service.impl;

import com.why.shopserver.permission.pojo.Permission;
import com.why.shopserver.permission.repository.PermissionRepository;
import com.why.shopserver.service.PermissionService;
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
}