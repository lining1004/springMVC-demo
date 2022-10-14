package com.briup.utils;

/**
 * 表示响应数据的状态： 成功  失败
 * @Author lining
 * @Date 2022/10/14
 */
public enum ResultCode {
    SUCCESS(1,"操作成功"),
    ERROR(0,"操作失败"),
    SYSTEM_INTER_ERROR(411,"系统内部错误"),
    CLASS_NOT_FOUND(410,"类找不到");
    private Integer code;
    private String msg;
    ResultCode(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
