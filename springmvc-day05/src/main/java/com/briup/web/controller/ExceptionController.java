package com.briup.web.controller;

import com.briup.web.exception.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.Map;

/**
 * @Author lining
 * @Date 2022/10/14
 */
@Controller
@RequestMapping("/error")
public class ExceptionController {
    @GetMapping("/test")
    public String method(String msg) throws Exception{
        System.out.println("msg:"+msg);
        if("0".equals(msg)){// msg.equal
            System.out.println(1/0);//产生的异常,交给SpringMVC--->交给tomcat-->
        }
        if("sql".equals(msg)){
            throw new SQLException("自定义的数据库异常");
        }

        if("tom".equals(msg)){
            throw new CustomException("权限不足");
        }
        if("class".equals(msg)){
            //类找不到异常
            //throw new ClassNotFoundException("自己模拟的");
            Class.forName("a.b.c");
        }
        if("IO".equals(msg)){
            //写代码模拟IO异常
            new FileInputStream("a/b/c");
        }
        return "hello";
    }
    //当异常发生时，自动调用该方法
    //作用范围：当前处理器中方法发生的异常信息
    //@ExceptionHandler(Exception.class)
    public String handlerException(Model map, Exception ex){
        System.out.println("调用异常处理方法"+ex.getMessage());
        map.addAttribute("ex",ex);
        return "error";
    }

}
