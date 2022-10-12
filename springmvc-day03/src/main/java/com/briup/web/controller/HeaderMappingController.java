package com.briup.web.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author lining
 * @Date 2022/10/12
 */
@Controller
@RequestMapping("/header")
public class HeaderMappingController {
    /*
    * 请求头 ：
    * GET请求 直接通过浏览器自动生成
    * POST请求 ： 设置Content-Type
    * Cookie:jsessionid=xxxxxxxx
    *
    *
    * */
    ///header/test
    //@RequestMapping(value = "/test",headers = {"username"})
    @RequestMapping(value = "/test",headers = {"Accept=text/html"})
    public String test(){
        return "hello";
    }
    /*
       consumes ： ContentType=text/html
      consumes ：告诉浏览器当前方法能够接收的请求报文中数据格式、
      以设置的请求头的Content-Type。

    * 请求头中请求参数值的映射要求
    *  Content-Type:客户端告诉服务器实际发送的数据类型
    *  application/json: 表示传递的数据格式为json字符串
    *  使用常量 MediaType类 表示 媒体类型 数据类型
    * */
    //@RequestMapping(value = "/test2",consumes = "application/json")
    //@RequestMapping(value = "/test2",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/test2",consumes = "text/html")
    public String test2(){
        return "hello";
    }
    /*

      produces  等同  Accept:application/json
                     Accept: 默认值
    * 通过设置响应报文中响应头的Content-type
    * 告诉浏览器我们服务器端返回的数据格式
    *  Accept:默认 表示浏览器接收任意类型的数据，
    * 但如果指定了浏览器只能接收text/html.访问路径提供406
    * 表示浏览器无法接收该类型的数据。
    * */
    @RequestMapping(value = "/test3",produces = MediaType.APPLICATION_JSON_VALUE)
    public void  test3(HttpServletResponse response) throws IOException {
        response.getWriter().println("hello world");
    }
}

