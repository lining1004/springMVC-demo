package com.briup.utils;

/**
 * 工具类 ：用来在web层返回Result对象的
 * @Author lining
 * @Date 2022/10/14
 */
public class ResultUtil {
    public static Result success(Integer code,String msg,Object data){
        return new Result(code,msg,data);
    }
    public static Result success(ResultCode resultCode,Object data){
        return new Result(resultCode.getCode(),resultCode.getMsg(),data);
    }
    public static Result success(Object data){
        return success(ResultCode.SUCCESS,data);
    }
    public static Result success(){
        return success(ResultCode.SUCCESS,null);
    }
    public static Result error(Integer code,String msg,Object data){
        return new Result(code,msg,data);
    }
    public static Result error(String msg){
        return new Result(ResultCode.ERROR.getCode(), msg,null);
    }
    public static Result error(ResultCode resultCode,Object data){
        return new Result(resultCode.getCode(),resultCode.getMsg(),data);
    }
}
