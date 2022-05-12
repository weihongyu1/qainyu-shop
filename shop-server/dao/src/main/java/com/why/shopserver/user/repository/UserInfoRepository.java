package com.why.shopserver.user.repository;

import com.why.shopserver.user.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * UserInfo数据操作
 *
 * @author why
 * @create 2022-04-21 14:43
 **/
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {

    final String table = "user_info";
    final String field = "id, phone_number, email, address, u_id, introduction, avatar";

    @Query(value = "SELECT " + field +" FROM " + table + " WHERE u_id = ?1",nativeQuery = true)
    UserInfo findUserInfo(Integer uId);
}
