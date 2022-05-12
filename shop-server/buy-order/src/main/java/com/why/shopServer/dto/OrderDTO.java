package com.why.shopServer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 订单数据实体类
 *
 * @author why
 * @create 2022-05-12 14:02
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    /** 订单号 **/
    private Integer OrderId;
    /** 商品Id **/
    private Integer commodityId;
    /** 收件人 **/
    private String recipient;
    /** 收货地址 **/
    private String address;
    /** 下单时间 **/
    private Date date;
    /** 支付状态 **/
    private String paymentStatus;
    /** 商品名称 **/
    private String commodityName;
    /** 商品分类 **/
    private String category;
    /** 商品描述 **/
    private String desc;
    /** 发货时间 **/
    private Date deliveryTime;
    /** 收件电话 **/
    private String phoneNumber;
    /** 用户名 **/
    private String username;
}
