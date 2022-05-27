package com.why.shopServer.service;

import com.why.shopServer.dto.OrderDTO;
import com.why.shopServer.order.pojo.Order;
import com.why.shopServer.user.pojo.UserLogin;
import com.why.shopServer.vo.order.PlaceOrderVo;
import com.why.shopServer.vo.order.UpdateVo;

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
     * @param orderVo
     * @return
     */
    Order placeOrder(PlaceOrderVo orderVo);

    /**
     * 修改订单
     * @param updateVo
     * @return
     */
    void updateOrder(UpdateVo updateVo);

    /**
     * 删除订单
     * @param orderId
     */
    void deleteOrder(Integer orderId);

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

    /**
     * 获取支付状态
     * @return
     */
    boolean getPayStatus(Integer id);
}
