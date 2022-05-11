package com.why.shopserver.order.repository;

import com.why.shopserver.order.pojo.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @InterfaceName：OrderRepository
 * @Description：
 * @Author: why
 * @create 2022-04-26 14:31
 **/
public interface OrderRepository extends JpaRepository<Order,Integer> {
    final String table = "order";
    final String field = "id, c_id, u_id, recipient, recive_phone, recive_address, pay";

    @Query(value = "SELECT " + field +" FROM " + table + " WHERE u_id = uid",nativeQuery = true)
    List<Order> findByuId(@Param("uid") Integer uId);
}
