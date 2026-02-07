package com.logistics.controller;

import lombok.Data;

/**
 * 通用返回结果封装
 */
@Data
public class Result<T> {
    /** 状态码：200成功，500失败 */
    private Integer code;
    
    /** 返回消息 */
    private String msg;
    
    /** 返回数据 */
    private T data;
    
    // 成功响应
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg("操作成功");
        result.setData(data);
        return result;
    }
    
    // 失败响应
    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}