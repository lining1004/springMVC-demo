package com.briup.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author lining
 * @Date 2022/10/12
 *
 */
@Controller
@RequestMapping("/method")
public class MethodMappingController {
    /*
    *   1.可以指定多个请求方法访问同一个url
    *   2.路径相同，但不同的请求方式可以访问到对应的不同方法上
    *
    * */
    @RequestMapping(path = "/test",method = {RequestMethod.GET})
    public String test(){
        System.out.println("test....");
        return "hello";
    }
    @RequestMapping(path = "/test",method = {RequestMethod.POST})
    public String test2(){
        System.out.println("test2.......");
        return "hello2";
    }
    /*
    *   案例： 实现一个新增用户和修改用户功能：
    *   请求报文：
    *   新增：  /addStudent
    *          请求体：name=jack
    *   修改：  /updateStudent
    *          请求体：id=1&name=tom
    *   RESTful：/student
    *      新增：POST /student
    *      修改：PUT  /student
    *
    * */
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public void addStudent(HttpServletResponse response) throws IOException {
        response.getWriter().println("addStudent...");
    }
    @RequestMapping(value = "/student",method = RequestMethod.PUT)
    public void updateStudent(HttpServletResponse response) throws IOException {
        response.getWriter().println("updateStudent...");
    }
    /*
    *  问题： POST /student   表示新增或修改学生信息
    *  1.方法逻辑中： 判断是否包含主键值
    *   如果前端传递参数为id=1&name=jack
    *   需要实现修改功能
    *   如果前端传递参数不包含主键值
    *   需要实现新增功能
    *
    *
    *
    * */
}
