package com.briup.web.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通过该控制器 讨论字符编码 乱码问题
 * @Author lining
 * @Date 2022/10/10
 */
public class FirstController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        /*
            1.接收请求参数时，如果参数为中文，会出现乱码吗？
            控制台乱码： 设置tomcat 读取 Dfile.encoding=utf-8  重启tomcat
            1.GET 不会乱码
            2.POST请求  利用客户端模拟页面发送一个post请求
             POST  localhost:8080/first
             请求头：
            Content-Type: application/x-www-form-urlencoded
            Post 请求 中文参数乱码
         */
        String username = request.getParameter("username");
        System.out.println("请求参数username: "+username);
        //2.service层中不会乱码 utf-8
        //3.dao层 操作数据库存储字符串可能造成乱码
        //4.返回结果中 可能产生乱码
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("username",username);
        return mv;

        //response.getWriter.println("hello "+username)
    }
}
