package com.why.shopServer.vo.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 下订单视图实体类
 *
 * @author why
 * @create 2022-05-14 14:17
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOrderVo {
    private String commodityName;
    private String username;
    private String recipient;
    private String phoneNumber;
    private String[] selectedOptions;
    private String address;
    private boolean paymentStatus;
    private Date date;
    private Date time;
    private String desc;
}
