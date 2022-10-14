package com.briup.web.exception;

import com.briup.web.exception.CustomException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 自定义异常解析器：
 * @Author lining
 * @Date 2022/10/14
 */
//@Component//xml 中创建bean对象
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        String viewName = "error";
        if(ex instanceof SQLException){
            viewName = "error_sql";
            //发送短信/邮件/提示管理员
        }
        // 业务异常提示: 密码错误 权限不足 账户锁定
        if(ex instanceof CustomException){

        }
        //
        mv.setViewName(viewName);
        mv.addObject("username","jack");
        mv.addObject("ex",ex);
        return mv;
    }
}
