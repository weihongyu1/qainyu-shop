package com.why.shopserver.vo.pay;

import lombok.Data;

/**
 * 支付接口传输实体
 *
 * @author why
 * @create 2022-05-16 13:33
 **/
@Data
public class PayVo {
    Integer orderId;
    String orderName;
    String orderPrice;
}
