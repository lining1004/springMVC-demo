package com.briup.web.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author lining
 * @Date 2022/10/10
 */
public class HiController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.接收参数
        String username = request.getParameter("username");
        /*
            2.直接使用响应对象返回数据
            当返回的字符串为中文时产生乱码，原因是什么？
            浏览器解析响应报文时，解码没有使用utf-8
            解决方案：告诉浏览器，你的解码方式是utf-8
         */
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("hello "+username);
        //3.使用响应对象进行返回，方法返回值设置null,
        return null;
    }
}
