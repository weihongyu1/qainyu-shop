package com.why.shopserver.buyorder.controller;

import com.sun.javafx.collections.MappingChange;
import com.why.shopServer.service.impl.OrderServiceImpl;
import com.why.shopserver.commonenum.StatusEnum;
import com.why.shopserver.order.pojo.Order;
import com.why.shopserver.user.pojo.UserLogin;
import com.why.shopserver.vo.ResultVo;
import com.why.shopserver.vo.order.PlaceOrderVo;
import com.why.shopserver.vo.order.UpdateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
        log.info(placeOrderVo.toString());
        if (orderService.placeOrder(placeOrderVo) == null){
            return ResultVo.success(StatusEnum.ORDER_PLACE_ERROR);
        }
        return ResultVo.success(StatusEnum.ORDER_PLACE_SUCCESS);
    }

    /**
     * 修改订单信息
     * @param updateVo
     * @return
     */
    @PostMapping("/update")
    public ResultVo updateOrder(@RequestBody UpdateVo updateVo){
        log.info(updateVo.toString());
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
        log.info(String.valueOf(delOrderId));
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
}
