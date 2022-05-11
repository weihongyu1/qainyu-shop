package com.why.shopserver.buyorder.controller;

import com.why.shopServer.service.impl.OrderServiceImpl;
import com.why.shopserver.commonenum.StatusEnum;
import com.why.shopserver.order.pojo.Order;
import com.why.shopserver.user.pojo.UserLogin;
import com.why.shopserver.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 订单数据接口
 *
 * @author why
 * @create 2022-04-26 15:21
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    /**
     * 下订单
     * @param order
     * @return
     */
    @PostMapping("/place")
    public ResultVo placeOrder(@RequestBody Order order){
        return ResultVo.success(StatusEnum.ORDER_PLACE_SUCCESS, orderService.placeOrder(order));
    }

    /**
     * 修改订单信息
     * @param order
     * @return
     */
    @PostMapping("/update")
    public ResultVo updateOrder(@RequestBody Order order){
        return ResultVo.success(StatusEnum.ORDER_UPDATE_SUCCESS, orderService.updateOrder(order));
    }

    /**
     * 删除订单信息
     * @param order
     * @return
     */
    @PostMapping("/delete")
    public ResultVo deleteOrder(@RequestBody Order order){
        orderService.deleteOrder(order);
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
}