package com.why.shopserver;

/**
 * 执行状态枚举类
 *
 * @author why
 * @create 2022-04-22 17:42
 **/
public enum StatusEnum {
    /**
     * 用户错误状态 10000开始
     */
    USERNAME_OR_PASSWORD_NULL(10000, "用户名或密码不能为空"),
    USERNAME_OR_PASSWORD_ERROR(10001, "用户名或密码错误"),
    /**
     * 用户成功状态从 20000开始
     */
    CERTIFICATION_SUCCESS(20000, "用户登录成功"),
    REFRESH_TOKEN_SUCCESS(20001, "刷新令牌成功"),
    REGISTER_SUCCESS(20002, "用户注册成功");

    private Integer code;
    private String msg;

    StatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}