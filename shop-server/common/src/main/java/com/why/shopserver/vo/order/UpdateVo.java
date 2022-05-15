package com.why.shopserver.vo.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单更新数据实体
 *
 * @author why
 * @create 2022-05-14 16:29
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateVo {
    private Integer orderId;
    private String recipient;
    private String address;
    private String phoneNumber;
    private String orderDesc;
}
