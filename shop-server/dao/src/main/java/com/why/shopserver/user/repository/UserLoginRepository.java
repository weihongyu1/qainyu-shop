package com.why.shopserver.user.repository;

import com.why.shopserver.user.pojo.UserLogin;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @InterfaceName：UserRepository
 * @Description：用户登录数据操作
 * @Author: why
 * @create 2022-04-22 16:48
 **/
public interface UserLoginRepository extends JpaRepository<UserLogin,Integer> {

    @NonNull
    UserLogin findByUsername(String username);
}
