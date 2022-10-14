package com.briup.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author lining
 * @Date 2022/10/14
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;//不确定的类型：泛型 [] null {}
    //当查询成功后，使用这个json字符串
    public static Result success(Object data){
        return new Result<>(1,"查询成功",data);
    }
    public static Result error(Object data){
        return new Result<>(0,"查询失败",data);
    }
    public static Result error(String msg){
        return new Result<>(0,msg,null); }
    public static Result error(String msg,Object data){
        return new Result<>(0,msg,data); }
    public static Result error(ResultCode code,Object data){
        return new Result<>(code.getCode(), code.getMsg(), data); }
}

