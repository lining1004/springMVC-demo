package com.briup.web.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 创建一个springMVC中的控制器/处理器
 * 作用： 接收请求，做出响应
 * 要求：必须实现一个Controller接口
 * @Author lining
 * @Date 2022/10/10
 */
public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.通过请求对象获取参数信息
        String username = request.getParameter("username");
        //2.封装参数，传递给service层（.....）

        //3.根据service方法，做出响应:通过模型视图对象实现
        ModelAndView mv = new ModelAndView();
        /*
        设置逻辑（虚拟）视图名称，交给视图解析器解析，
        获取视图的(物理)真实视图名：/jsp/hello.jsp
         */
        mv.setViewName("hello");
        //设置模型数据   map结构
        mv.addObject("username",username);
        return mv;
    }
}
