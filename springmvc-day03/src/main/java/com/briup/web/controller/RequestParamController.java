package com.briup.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author lining
 * @Date 2022/10/12
 */
@Controller
@RequestMapping("/param")
public class RequestParamController {
    /*
    *   1.通过请求对象实现获取请求参数
    *     request.getParamter()
    *   2.直接获取到请求参数
    *
    *
    * */
    //localhost:8080/param/test?id=1
    @RequestMapping("/test")
    public String test(String id){
        System.out.println("请求参数名与方法参数名相同： 自动将请求参数映射到方法参数："+id);
        return "hello";
    }
    /*
    *  请求参数与方法参数映射问题
    *  1@RequestParam 默认要求参数名必须提供 userId
    * */
    @RequestMapping("/test2")
    public String test2(@RequestParam(value = "userId",required = false) String id){
        System.out.println("请求参数名与方法参数名相同： 自动将请求参数绑定到方法参数："+id);
        return "hello";
    }

    /*
    * 实现请求参数映射
    * 当模拟表单请求：
    *  POST /param/test3
    *  请求头 指定 Content-Type:x-www-form-url....
    *  请求体： userId=1&username=tom
    *
    * */
    @RequestMapping(value = "/test3",params = {"username","userId"})
    public String test3(){
        return "hello";
    }
    //@RequestMapping(value = "/test4",params = {"username=admin"})
    @RequestMapping(value = "/test4",params = {"!username"})
    public String test4(){
        return "hello";
    }
}

