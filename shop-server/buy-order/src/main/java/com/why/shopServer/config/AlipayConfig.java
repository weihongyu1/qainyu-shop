package com.why.shopServer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 支付宝支付组件配置类
 *
 * @author why
 * @create 2022-05-16 13:03
 **/
@Configuration
@ConfigurationProperties(prefix = "alipay")
@PropertySource("classpath:/application-dev.yml")
@Component
@Data
public class AlipayConfig {
    // 商户appid
    public static String APPID = "2021000119695837";
    // 私钥 pkcs8格式的
    public static String RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDHDQxhG2Z9UW7W0k0jFSUTGu47SSjrhNGurv4dCcTE46S3rKmiyPpnE1E9jZwE/nS8Mjy8tNnV6VFb7MP75xa2NPzK7Bz6DBu3Wo55MxiTGRTmW6ng2ShXCwNx9xiDDMEZChEUcd6goCqfT7KeEbinRWVZCN8G/2X0azKwF163nT2RK6vtb/dT4750cNPM/vvqJBmN9CyQMCaxpJGjanZzCGI5dHtHoLgZfALTVul8QtfY0OGEpV5AOCw2TV+49+dacX+cOA/RR7qDrzEqJkb8CaaAD5fcjuZCKNpFhLGvJ7HvSQai6fncuPs0cMAmYRebdqG7Myunri8aAIjmbzD1AgMBAAECggEAMWpt3lW9FfN3fuFqwQDo2VtgNVuuSvoITEOpVnAsZ2zUYbz9yCn48En9aziSuTKqrGYUagzD37Uyu42GAi2Wl9mDwKTpdLI410YmBLTIrwwVAjNTczy2JRXY3xwm+7HY5mx3XQn/6QSaUD6q608e9nfl9zqak9Qn7YwHY2wJ2a9A/kg0gY0UmUSVoKDC8K45zc7M6EzRSUksVmLKd0zb88hZDMo6wonItQP0r8XGKwMLdDEFCwqak5X/84IwiSCloRReFhPXM0L0YL/ilEFKMVBPo5eG/o+fC96MXFT6ywwSUVBf+Mpw6wA63Rs26d/0RjgUGJdrRRniYl+h/YvXQQKBgQD6iu8fA41srkyM28S/pAk7uCp2eurp12VhKT+sKqlcO+gaNkTPbGmseJsSxDEEtDbarniknortOT074/+PW/AC8Svtap4K1a8vJYZpSrB5uuctqhuaWcTCCx7A5VYV9HRaHMcwXsNlugS0uiWUxtUl5PtPoe1vTiU2DjqSqBvGyQKBgQDLYvz4goQRxOIzn26QUFc75jA5cnxhbxWkZyUoh9arn5EdqzXYp/GK2Ej6kvbZOE8a2ke6ja5aBT2Iy93Iof3/wxWQA/D6xP6qty5MYvCGD+jGQDyklAZhFX/6bYkIS/qpZkZHCFppoTkLg+wByRyCn+m1d5eu33LjxNeMHI/yzQKBgQCPN9JfITG72ZsKviom/ocEq08isTsN90INm325Vh3ACsKwESuegrOZksvam2oF7VqaATgXqkVyO9EkJj4VXhHCLMjWi6bSPLpKsiG2mKpuu4ehE+d5gS03WxH2ZGKkZDwKsv6uSM1bnk1IXkxTUqHPaqi6Ka9HfB1LXDDhWtWd+QKBgQCXeSSgTEviE/jHq6CjeEJPyRL3Ze1+f0XmCC+jbO+TKCbiqsVSk1mQJ57Kh7OyeX5oqFKtfKFyR97ZR8PojcTmu7sOY/EQQrDMIdsoZrNtlOGu7N59UAUkPufuca+R70xC53nFo1H6w2kBy4F0nvxNyJ09WlEsmxwsyEgkAI2wrQKBgDr3iIL5WUDIkLv3vpArA49VujEiz1edxlNHKiByTt24u/mDCG3/k5cVi13rtFp/uSgtBFs360p4Q1vUsvDADHXLp+R8GcamwJREK3F313LnZaJijN82Do0tzYf3kY3zBNg0yXOB25p3LeXFqusXWlsLxykWJ7xWBagyN6O/4rwu";
    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8888/alipay.trade.wap.pay-JAVA-UTF-8/notify_url.jsp";
    // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = "http://localhost:8888/alipay.trade.wap.pay-JAVA-UTF-8/return_url.jsp";
    // 请求网关地址
    public static String URL = "https://openapi.alipaydev.com/gateway.do";
    // 编码
    public static String CHARSET = "UTF-8";
    // 返回格式
    public static String FORMAT = "json";
    // 支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiNiAyQTSIU0UziLmfNwIChDH4wdD4Cz/kQzaMcCE2eId0dCsgTzukNq32wpA2ZK9BWzmW5iYHubDtGHmgbGPr1kL3rTnPYYJzPH5wPThRbT7zvIfXjOrLZmM3yHiOrL6e59urGvsYMIQF2ZAtJ6FAQvMgfF3ZVWO4+sepRkAa7+XsQgouFdoNGesQyBxvsP/4lR9LEtnEWrwKMeMQPmOW4ZyrxinwsWHQt6XHjtb6UinKVQfTop9hZdqb6A9wUBZtr2I+JzeMrmhL6jRGRvusyIO6hvCCoHoaw7TNdWfxfnKHxfGP6KXFuJLP72yNq4XPY74pezPmfjcDanOb9eWlQIDAQAB";
    // 日志记录目录
    public static String log_path = "/log";
    // RSA2
    public static String SIGNTYPE = "RSA2";

    public static String REDIRECT_URI = "http://localhost:9527/#/dashboard";
}
