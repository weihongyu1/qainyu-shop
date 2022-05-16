package com.why.shopserver.buyorder.controller;

import com.alipay.api.AlipayApiException;
import com.why.shopServer.service.impl.PayServiceImpl;
import com.why.shopserver.commonenum.StatusEnum;
import com.why.shopserver.vo.ResultVo;
import com.why.shopserver.vo.pay.PayVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付宝支付接口
 *
 * @author why
 * @create 2022-05-16 13:10
 **/
@RestController
@RequestMapping("/order")
@Slf4j
public class AlipayController {

    @Autowired
    private PayServiceImpl payService;

    @PostMapping(value = "/alipay")
    public ResultVo alipay(@RequestBody PayVo payVo) throws AlipayApiException {
        log.info(payVo.toString());
        return ResultVo.success(StatusEnum.ORDER_PAY_SUCCESS, payService.pay(payVo));
    }
}
