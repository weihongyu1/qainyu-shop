package com.why.shopserver.commonenum;

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
    AUTHENTICATION_ERROR(10002,"验证失败"),
    USER_INFO_UPDATE_ERROR(10003, "修改用户基础信息失败"),
    /**
     * 用户成功状态从 20000开始
     */
    CERTIFICATION_SUCCESS(20000, "用户登录成功"),
    REFRESH_TOKEN_SUCCESS(20001, "刷新令牌成功"),
    REGISTER_SUCCESS(20002, "用户注册成功"),
    USER_LOGIN_UPDATE_SUCCESS(20003, "修改用户登录信息成功"),
    USER_INFO_UPDATE_SUCCESS(20004, "修改用户基础信息成功"),
    USER_INFO_GET_SUCCESS(20000, "获取用户信息成功"),
    USER_PERMISSION_GET_ALL_SUCCESS(20006, "获取用户所有权限信息成功"),

    /**
     * 商品成功状态 30000开始
     */
    COMMODITY_TAKE_UP_SUCCESS(30000, "商品上架成功"),
    COMMODITY_TAKE_DOWN_SUCCESS(30001, "商品下架成功"),
    COMMODITY_UPDATE_INFO_SUCCESS(30002, "商品信息更新成功"),
    COMMODITY_GET_ALL_SUCCESS(30003, "获取所有商品信息成功"),
    COMMODITY_SEARCH_BY_NAME_SUCCESS(30004, "根据商品名称获取商品信息成功"),

    /**
     * 订单成功状态 40000开始
     */
    ORDER_PLACE_SUCCESS(40000, "下订单成功"),
    ORDER_UPDATE_SUCCESS(40001, "修改订单信息成功"),
    ORDER_DELETE_SUCCESS(40002, "删除订单成功"),
    ORDER_GET_BY_USER_SUCCESS(40003, "获取用户订单成功"),
    ORDER_GET_ALL_SUCCESS(40004, "获取所有订单成功");

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