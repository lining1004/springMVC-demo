package com.briup.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用来测试注解
 * 1.控制器类不需要实现任何接口
 * 2.每个请求对应一个映射关系确定要调用的方法
 * @Author lining
 * @Date 2022/10/11
 * /student/find
 * /student/add
 * /student/update
 *
 */
@Controller  //@Compont 创建Bean对象
@RequestMapping("/student")  //类中所有的方法请求基于/student进行
public class StudentController {
    public StudentController() {
        //第一次访问时创建
        System.out.println("创建控制器对象");
    }

    //接收请求，做出响应
    //springMVC  modelAndView
    //当请求路径为/method时，自动调用该方法
    @RequestMapping(path = "/method")
    public ModelAndView method(HttpServletRequest req, HttpServletResponse resp){
        String username = req.getParameter("username");
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("username",username);
        mv.addObject("userId",1);
        return mv;
    }
    @RequestMapping("/method2")
    public String method2(Model model){
        //如何处理模型的数据设置 mv.add ? 参数列表中定义一个Model对象
        model.addAttribute("username","tom");
        model.addAttribute("userId",1);
        return "hello";//返回的逻辑视图名

        //将model对象中设置的值渲染到逻辑视图hello中
        // Model对象  View对象  ModelAndView()
    }
    //反编译：class --->java
    //POST请求 PUT  GET POST PUT DELETE 都可以访问
    @RequestMapping("/method3")
    public void method4(HttpServletResponse response) throws Exception{
        //当方法无返回值,使用响应对象做出返回
        System.out.println("method3....");
        response.getWriter().println("hello world");
    }

    /*
         请求方法  任意
         请求url
         请求头
         请求参数



     */

}
