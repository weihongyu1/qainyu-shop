package com.why.shopServer.user.repository;

import com.why.shopServer.user.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * UserInfo数据操作
 *
 * @author why
 * @create 2022-04-21 14:43
 **/
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {

    String table = "user_info";
    String field = "id, phone_number, email, address, u_id, introduction, avatar, create_date";

    @Query(value = "SELECT " + field +" FROM " + table + " WHERE u_id = ?1",nativeQuery = true)
    UserInfo findUserInfo(Integer uId);

    @Modifying
    @Query(value = "DELETE FROM " + table + " WHERE u_id = ?1",nativeQuery = true)
    void deleteUserInfoByUId(Integer uId);
}
