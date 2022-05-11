package com.why.shopserver.commodity.pojo;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 商品实体类
 *
 * @author why
 * @create 2022-04-26 14:17
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //标记实体类
@Table(name = "commodity")
public class Commodity implements Serializable {
    /** 主键id **/
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    /** 商品名称 **/
    @Column(name="commodity_name")
    @NotNull
    private String commodityName;

    /** 商品描述 **/
    @Column(name="commodity_describe")
    @NotNull
    private String commodityDescribe;

    /** 商品库存 **/
    @Column(name = "stock")
    private Integer stock;

    /** 发货地址 **/
    @Column(name = "ship_address")
    private String shipAddress;

    /** 是否下架 **/
    @Column(name = "take_down")
    private Integer takeDown;

    /** 上架爱时间 **/
    @Column(name = "take_up_time")
    private Date takeUpTime;
}