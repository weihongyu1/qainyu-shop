package com.why.shopServer.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.why.shopServer.config.AlipayConfig;
import com.why.shopServer.service.PayService;
import com.why.shopServer.order.repository.OrderRepository;
import com.why.shopServer.vo.pay.PayVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 支付接口实现类
 *
 * @author why
 * @create 2022-05-16 14:59
 **/
@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private OrderRepository orderRepository;

    private final Integer PAID = 1;

    @Override
    @Transactional
    public String pay(PayVo payVo) {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID,
                AlipayConfig.RSA_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY,
                AlipayConfig.SIGNTYPE);

        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();

        /** 同步通知，支付完成后，支付成功页面 */
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        /** 异步通知，支付完成后，需要进行的异步处理 */
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        alipayRequest.setBizContent(
                "{\"out_trade_no\":\"" + payVo.getOrderId() + "\"," +
                        "\"total_amount\":\"" + payVo.getOrderPrice() + "\"," +
                        "\"subject\":\"" + payVo.getOrderName() + "\"," +
                        "\"body\":\"付款\"," + "\"timeout_express\":\"15m\"," +
                        "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}"
        );

        /** 转换格式 */
        String form = "";

        try {
            form = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        orderRepository.updatePaymentStatus(PAID, payVo.getOrderId());

        return form;
    }
}
