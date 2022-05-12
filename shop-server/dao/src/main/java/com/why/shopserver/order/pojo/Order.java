package com.why.shopserver.order.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 订单实体类
 *
 * @author why
 * @create 2022-04-26 14:25
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order")
public class Order implements Serializable {

    /** 主键id **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    /** 商品id，外键 **/
    @Column(name = "c_id")
    private Integer cId;

    /** 用户id，外键 **/
    @Column(name = "u_id")
    private Integer uId;

    /** 收件人 **/
    @Column(name = "recipient")
    private String recipient;

    /** 收件电话 **/
    @Column(name = "recive_phone")
    private String recivePhone;

    /** 收件地址 **/
    @Column(name = "recive_address")
    private String reciveAddress;

    /** 支付状态 **/
    @Column(name = "payment_tatus")
    private Integer paymentStatus;

    /** 下单时间 **/
    @Column(name = "order_date")
    private Date orderDate;

    /** 发货时间 **/
    @Column(name = "delivery_time")
    private Date deliveryTime;
}
