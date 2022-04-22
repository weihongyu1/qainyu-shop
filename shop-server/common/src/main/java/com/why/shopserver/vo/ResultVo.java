package com.why.shopserver.vo;

import com.why.shopserver.StatusEnum;
import lombok.Data;

import java.util.Stack;

/**
 * 同一封装返回结果
 *
 * @author why
 * @create 2022-04-22 17:34
 **/
@Data
public class ResultVo {
    /** 状态码 **/
    private Integer code;

    /** 结果信息 **/
    private String msg;

    /** 数据 **/
    private Object data;

    public ResultVo(String msg) {
        this.msg = msg;
    }

    public ResultVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVo(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResultVo success(StatusEnum statusEnum, Object data){
        return new ResultVo(statusEnum.getCode(), statusEnum.getMsg(), data);
    }

    public static ResultVo success(StatusEnum statusEnum){
        return new ResultVo(statusEnum.getCode(), statusEnum.getMsg());
    }

    public static ResultVo error(StatusEnum statusEnum){
        return new ResultVo(statusEnum.getCode(), statusEnum.getMsg());
    }

    public static ResultVo error(String msg){
        return new ResultVo(msg);
    }
}