package com.why.shopserver.user.repository;

import com.why.shopserver.user.pojo.UserLogin;
import com.why.shopserver.user.pojo.UserLoginList;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @InterfaceName：UserLoginListRepository
 * @Description： 用户登录表数据操作接口
 * @Author: why
 * @create 2022-05-15 14:46
 **/
public interface UserLoginListRepository  extends JpaRepository<UserLoginList,Integer>  {

    String table = "user_login_list";
    String field = "id, u_id, login_time";

    @Query(value = "SELECT " + field +" FROM " + table + " WHERE u_id = ?1",nativeQuery = true)
    UserLoginList findUserLoginListByUId(Integer uId);

    @Modifying
    @Query(value = "DELETE FROM " + table + " WHERE u_id = ?1",nativeQuery = true)
    void deleteByUId(Integer uId);
}
