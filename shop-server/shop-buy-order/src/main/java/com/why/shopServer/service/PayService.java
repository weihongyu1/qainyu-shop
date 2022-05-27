package com.why.shopServer.service;

import com.why.shopServer.vo.pay.PayVo;

/**
 * @InterfaceName：PayService
 * @Description：支付接口
 * @Author: why
 * @create 2022-05-16 14:58
 **/
public interface PayService {
    String pay(PayVo payVo);
}
