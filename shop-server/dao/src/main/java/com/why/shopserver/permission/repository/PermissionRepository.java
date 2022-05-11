package com.why.shopserver.permission.repository;

import com.why.shopserver.permission.pojo.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @InterfaceName：RermissionRepository
 * @Description：权限表数据操作接口
 * @Author: why
 * @create 2022-04-28 16:08
 **/
public interface PermissionRepository  extends JpaRepository<Permission,Integer> {
}
