package com.briup.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 数据绑定
 * @Author lining
 * @Date 2022/10/12
 */
@Controller
@RequestMapping("/data")
public class DataBinderController {
    /*
        GET  /test  id=1&name=tom
        接口：interface
        前端后接口：请求和响应的规则是什么？
        A系统    B系统
     */
    @RequestMapping("/test")
    public String test(@RequestParam(value = "username",required = false,defaultValue = "lisi") String name){
        System.out.println(name);
        return "hello";
    }
    // /student/all?pageNum=1&pageSize=10
    //分页数据 查询几页 每个显示条数
    public String findAll(@RequestParam(required = false,defaultValue = "1") int pageNum,@RequestParam(required = false,defaultValue = "10") int pageSize){
        return "hello";
    }
    @RequestMapping("/test2/{username}/{userId}")
    public String test2(Map model, @PathVariable String username, @PathVariable String userId){
        System.out.println("模型数据："+model);
        return "hello";
    }
    /*
    Cookie:
	username=tom;
	JSESSIONID=0EDC047177812AE6F3C7F1715F093FD8
    获取到请求头中Cookie中对应的值
     */
    @RequestMapping("/test3")
    public String test3(@CookieValue(name = "username",required = false) String value){
        System.out.println("cookie保存的值："+value);
        return "hello";
    }
    @RequestMapping("/test4")
    public String test4(@CookieValue("JSESSIONID") Cookie cookie){
        System.out.println(cookie);
        String value = cookie.getValue();
        System.out.println(value);
        return "hello";
    }
    @RequestMapping("/addCookie")
    public void addCookie(HttpServletResponse response) throws IOException {
        //将自定义的cookie信息保存到浏览器中，会话期间存在
        Cookie cookie = new Cookie("username","tom");
        response.addCookie(cookie);
        response.getWriter().println("add cookie");
    }
    /*
      当请求头参数错误提示状态码：400错误

     */
    @RequestMapping("/test5")
    public String test5(@RequestHeader(value = "username",required = false) String accept){
        System.out.println("accpet:"+accept);
        return "hello";
    }
    //404 没有映射请求头参数
    @RequestMapping(value = "/test6",headers = {"username"})
    public String test6(){
        return "hello";
    }
    // @RequestMapping(value="url",Method=GET)
    // @GetMapping(“url”)
}
