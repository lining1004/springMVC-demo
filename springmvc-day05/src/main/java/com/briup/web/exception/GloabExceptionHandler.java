package com.briup.web.exception;

import com.briup.utils.Result;
import com.briup.utils.ResultCode;
import com.briup.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理 web层
 * @Author lining
 * @Date 2022/10/14
 * spring aop
 */
@ControllerAdvice
public class GloabExceptionHandler {
    public GloabExceptionHandler() {
        System.out.println("创建全局异常处理对象");
    }
    /*@ExceptionHandler(Exception.class)
    public String handlerException(Exception ex){
        System.out.println("处理异常："+ ex.getMessage());
        return "error";
    }*/
    /*
    *  基于RESTful风格的请求响应中。前后端项目分离
    *   响应的数据是json格式数据。
    *   如何实现返回数据？？？
    * */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handlerException(Exception ex){
        /*
        * 提示用户josn
        *   javaAPI 中的Exception类
            {"code":0,"msg":"系统内部错误","data":"异常信息"}
            用户自定义异常 ： 密码错误  权限不足
            {"code":0,"msg":"密码错误","data":null}
            * 不同错误对应不同错误状态码
            1  成功
            0  失败
            410  密码错误
            411  用户不存在
            412  权限不足
        *
        * */
        if(ex instanceof CustomException){
            return ResultUtil.error(ex.getMessage());
        }
        if(ex instanceof ClassNotFoundException){
            return ResultUtil.error(ResultCode.CLASS_NOT_FOUND,ex.getMessage());
        }
        //
        return Result.error(ResultCode.SYSTEM_INTER_ERROR,ex.getMessage());
    }
}
