package com.briup.web.controller;

import com.briup.bean.Student;
import com.briup.bean.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Date;

/**
 * @Author lining
 * @Date 2022/10/13
 */
@Controller
@RequestMapping("/request")
public class RequestBodyController {
    /*
      @RequestBody Student s
      表示springMVC会获取请求报文中的请求体信息
      请求体字符串信息为json格式字符串，springMVC利用jackson代码实现
      将json字符串自动转换为Student对象
       注意： 设置请求头Content-Type:application/json
        测试数据 :{"id":1,"name":"tom"}

     */
    @PostMapping(value = "/test",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String method(@RequestBody Student s){
        System.out.println(s);
        return "hello";
    }
    @GetMapping("/test2")
    @ResponseBody
    public String method2(){
        return "hello"; //返回是响应体一个字符串信息
    }
    @GetMapping(value = "/test3",produces =MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Student method3(){
        /*
            使用@ResponseBody 实现将java对象转换为json字符串
            转换过程中使用的jackson实现
            允许浏览器当前请求接收媒体是application/json 默认
            accept
         */
        return new Student(1,"tom",new Date());
    }

    @PostMapping(value = "/test4",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Student method4(@RequestBody Student s){
        //通过处理json字符串数据实现请求和响应
        return s;
    }
    @GetMapping("/method5")
    @ResponseBody
    public User method5(){
        //如果将响应信息的时间对象转换指定格式的字符串
        return new User(1,"jack",new Date());
    }
}
