package com.briup.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author lining
 * @Date 2022/10/14
 */
@Controller
@RequestMapping("/page")
public class PageController {
    @GetMapping("/servlet")
    public void servelt(HttpServletRequest request,HttpServletResponse response) throws Exception{
        //通过内部跳转实现访问一个页面资源或servlet资源
        String path = "/WEB-INF/jsp/hello.jsp";//基于项目目录
        request.getRequestDispatcher(path).forward(request,response);

    }
    @GetMapping("/servlet2")
    public void servlet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //重定向是否可以实现直接访问hello.jsp页面。
       // String path = "/project/WEB-INF/jsp/hello.jsp";
        //间接访问  servelt2---servlet---->jsp
        String path = "/project/page/servlet";
        response.sendRedirect(path);
    }
    @GetMapping("/mv")
    public ModelAndView test3(){
        String viewName = "hello";
        /*
            MV对象也可以实现内部跳转和重定向
            重定向路径 第一个斜杠表示项目根目录
         */
        viewName = "forward:/page/servlet"; //表示内部跳转的一个动态资源
        viewName = "forward:/WEB-INF/jsp/hello.jsp";//表示内部跳转的一个页面
        //viewName = "redirect:/page/servlet";//表示重定向到一个动态资源
        viewName = "redirect:/WEB-INF/jsp/hello.jsp";//重定向 无法直接通过浏览器访问安全目录资源
        ModelAndView mv = new ModelAndView();
        mv.setViewName(viewName);
        return mv;
    }
    @GetMapping("/string")
    public String test4(){
        //1.表示逻辑视图名 return "hello";
        //2.表示内部跳转：页面 动态资源
        //return "forward:/page/servlet";
        //3.表示重定向的跳转：非安全目录下的页面 动态
        return "redirect:/page/servlet";
    }


}
