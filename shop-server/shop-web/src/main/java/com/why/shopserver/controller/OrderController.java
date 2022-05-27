package com.why.shopServer.controller;

import com.why.shopServer.commonenum.StatusEnum;
import com.why.shopServer.order.pojo.Order;
import com.why.shopServer.service.impl.OrderServiceImpl;
import com.why.shopServer.user.pojo.UserLogin;
import com.why.shopServer.vo.ResultVo;
import com.why.shopServer.vo.order.PlaceOrderVo;
import com.why.shopServer.vo.order.UpdateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

/**
 * 订单数据接口
 *
 * @author why
 * @create 2022-04-26 15:21
 **/
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    /**
     * 下订单
     * @param placeOrderVo
     * @return
     */
    @PostMapping("/place")
    public ResultVo placeOrder(@RequestBody PlaceOrderVo placeOrderVo){
        Order order = orderService.placeOrder(placeOrderVo);
        if (order == null){
            return ResultVo.success(StatusEnum.ORDER_PLACE_ERROR);
        }
        return ResultVo.success(StatusEnum.ORDER_PLACE_SUCCESS, order);
    }

    /**
     * 修改订单信息
     * @param updateVo
     * @return
     */
    @PostMapping("/update")
    public ResultVo updateOrder(@RequestBody UpdateVo updateVo){
        orderService.updateOrder(updateVo);
        return ResultVo.success(StatusEnum.ORDER_UPDATE_SUCCESS);
    }

    /**
     * 删除订单信息
     * @param delOrderId
     * @return
     */
    @GetMapping("/delete")
    public ResultVo deleteOrder(@Param("delOrderId") Integer delOrderId){
        orderService.deleteOrder(delOrderId);
        return ResultVo.success(StatusEnum.ORDER_DELETE_SUCCESS);
    }

    /**
     * 获取登录用户的信息
     * @param userLogin
     * @return
     */
    @GetMapping("/get_order")
    public ResultVo getOrderByUser(@RequestBody UserLogin userLogin){
        return ResultVo.success(StatusEnum.ORDER_GET_BY_USER_SUCCESS, orderService.getOrderByUser(userLogin));
    }

    /**
     * 获取所有订单信息
     * @return
     */
    @GetMapping("/get_all")
    public ResultVo getAll(){
        return ResultVo.success(StatusEnum.ORDER_GET_ALL_SUCCESS, orderService.getAll());
    }

    @GetMapping("/get_pay")
    public boolean getPayStatus(@Param("id") Integer id){
        log.info(String.valueOf(id));
        return orderService.getPayStatus(id);
    }
}
