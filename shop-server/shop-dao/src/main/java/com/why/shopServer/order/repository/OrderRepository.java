package com.why.shopServer.order.repository;

import com.why.shopServer.order.pojo.Order;
import com.why.shopServer.vo.order.UpdateVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
    final String table = "tbl_order";
    final String field = "id, c_id, u_id, recipient, recive_phone, options, payment_status, recive_address, order_date, delivery_time, order_desc";

    @Query(value = "SELECT " + field +" FROM " + table + " WHERE u_id = uid",nativeQuery = true)
    List<Order> findByuId(@Param("uid") Integer uId);

    @Modifying
    @Query(value = "UPDATE " + table +
            " SET recipient = :#{#order.recipient}, recive_address = :#{#order.address}, recive_phone = :#{#order.phoneNumber}, order_desc = :#{#order.orderDesc}" +
            " WHERE id = :#{#order.orderId}", nativeQuery = true)
    void update(@Param("order") UpdateVo updateVo);

    void deleteById(Integer orderId);

    @Modifying
    @Query(value = "DELETE FROM " + table + " WHERE u_id = ?1",nativeQuery = true)
    void deleteByUId(Integer uId);

    @Modifying
    @Query(value = "UPDATE " + table + " SET payment_status = ?1 " + " WHERE id = ?2", nativeQuery = true)
    void updatePaymentStatus(Integer paymentStatus, Integer orderId);
}
