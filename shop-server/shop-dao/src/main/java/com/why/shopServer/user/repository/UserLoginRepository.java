package com.why.shopServer.user.repository;

import com.why.shopServer.user.pojo.UserLogin;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @InterfaceName：UserRepository
 * @Description：用户登录数据操作
 * @Author: why
 * @create 2022-04-22 16:48
 **/
public interface UserLoginRepository extends JpaRepository<UserLogin,Integer> {

    String table = "user_login";

    UserLogin findByUsername(String username);

    UserLogin findUserLoginById(Integer id);

    @Modifying
    @Query(value = "DELETE FROM " + table + " WHERE u_id = ?1",nativeQuery = true)
    void deleteByUId(Integer id);
}
