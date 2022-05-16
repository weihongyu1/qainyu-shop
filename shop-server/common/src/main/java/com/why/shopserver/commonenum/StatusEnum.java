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
     * 用户成功状态
     */
    CERTIFICATION_SUCCESS(20000, "用户登录成功"),
    REFRESH_TOKEN_SUCCESS(20000, "刷新令牌成功"),
    REGISTER_SUCCESS(20000, "用户注册成功"),
    USER_LOGIN_UPDATE_SUCCESS(20000, "修改用户登录信息成功"),
    USER_INFO_UPDATE_SUCCESS(20000, "修改用户基础信息成功"),
    USER_INFO_GET_SUCCESS(20000, "获取用户信息成功"),
    USER_PERMISSION_GET_ALL_SUCCESS(20000, "获取用户所有权限信息成功"),
    USER_GET_ALL_SUCCESS(20000, "获取用户列表成功"),
    USER_DELETE_SUCCESS(20000, "用户删除成功"),

    /**
     * 商品成功状态
     */
    COMMODITY_TAKE_UP_SUCCESS(20000, "商品上架成功"),
    COMMODITY_TAKE_DOWN_SUCCESS(20000, "商品下架成功"),
    COMMODITY_UPDATE_INFO_SUCCESS(20000, "商品信息更新成功"),
    COMMODITY_GET_ALL_SUCCESS(20000, "获取所有商品信息成功"),
    COMMODITY_SEARCH_BY_NAME_SUCCESS(20000, "根据商品名称获取商品信息成功"),

    /**
     * 订单成功状态
     */
    ORDER_PLACE_SUCCESS(20000, "下订单成功"),
    ORDER_PLACE_ERROR(20000, "商品库存不足"),
    ORDER_UPDATE_SUCCESS(20000, "修改订单信息成功"),
    ORDER_DELETE_SUCCESS(20000, "删除订单成功"),
    ORDER_GET_BY_USER_SUCCESS(20000, "获取用户订单成功"),
    ORDER_GET_ALL_SUCCESS(20000, "获取所有订单成功"),
    ORDER_PAY_SUCCESS(20000, "订单支付成功");

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
