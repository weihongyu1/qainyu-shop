package com.why.shopserver.user.repository;

import com.why.shopserver.user.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserInfo数据表操作
 *
 * @author why
 * @create 2022-04-21 14:43
 **/
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
}