package com.why.shopServer.service;

import com.why.shopServer.dto.OrderDTO;
import com.why.shopserver.order.pojo.Order;
import com.why.shopserver.user.pojo.UserLogin;

import java.util.List;

/**
 * @InterfaceName：OrderService
 * @Description：订单业务接口
 * @Author: why
 * @create 2022-04-26 14:33
 **/
public interface OrderService {

    /**
     * 下订单
     * @param order
     * @return
     */
    Order placeOrder(Order order);

    /**
     * 修改订单
     * @param order
     * @return
     */
    Order updateOrder(Order order);

    /**
     * 删除订单
     * @param order
     */
    void deleteOrder(Order order);

    /**
     * 返回用户的所有订单
     * @param userLogin
     */
    List<Order> getOrderByUser(UserLogin userLogin);

    /**
     * 获取所有订单
     * @return
     */
    List<OrderDTO> getAll();
}
