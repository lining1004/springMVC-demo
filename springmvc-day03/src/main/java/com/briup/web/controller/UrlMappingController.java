package com.briup.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器： 1.不需要实现任何接口
 * 2.方法 定义 返回值类型 方法名 参数  任意指定
 * @Author lining
 * @Date 2022/10/12
 */
@Controller
@RequestMapping("/url") //路径前缀
public class UrlMappingController {

    /*
          路径映射： 使用参数名value  path
          1.一个方法可以映射多个请求url
          2.RESTful风格的请求
            查询功能：编写路径
            传统：/findStudentById?id=1
            Restful 资源
            GET方式实现查询操作
            资源信息使用路径表示
            参数值id=1直接定义在请求路径上
            RESTful:  GET /student/1
            GET /student/1
            GET /student/2
            GET /student/不确定值

     */

    @RequestMapping(path = {"/test","/method20"})
    public String test(){
        return "hello";
    }
    @RequestMapping(path = "/test2/**")
    public String method(){
        System.out.println("/test2/**");
        return "hello";
    }
    /*
        url模版路径
        /test2 无法访问
        /test2/123
        /test2/abc
        @PathVariable 获取路径中模版参数值
     */
    @RequestMapping(value = "/test2/{id}")
    public String test2(@PathVariable("id") String userId){
        //如何在方法中获取路径中参数
        System.out.println("路径中userId:"+userId);
        return "hello";
    }
    /*
       Ant风格：匹配模式
        **  任意子路径 Mybatis
        http://localhost:8080/url/test3/a/b/c/d
        *   0或任意字符 只有一个子路径，子路径名称不限制
            localhost:8080/url/test3/abc
            localhost:8080/url/test3/
        ?   1或任意 只有一个子路径，子路径名称只有一个字符
        http://localhost:8080/url/test3/a
        http://localhost:8080/url/test3/1

     */
    @RequestMapping("/test3/?")
    public String test3(){
        return "hello";
    }
    /*
        value="/student/{id}"
        value="/student/**"
        访问优先级： 模版url > ant风格路径
     */
    /*
      ant 和 模版混合使用

       查询 指定班级中的某个名字的学生
        GET /findStudentById?class=1&name=tom
        RESTful:
        /class/{classId}/student/{name}
        http://localhost:8080/url/class/1/student/tom
        /class/student/{classId}/{name}
     */
    @RequestMapping("/class/{classId}/student/{name}")
    public String findStudent(@PathVariable String classId,@PathVariable String name){
        System.out.println("classId:"+classId);
        System.out.println("name:"+name);
        return "hello";
    }
    /*
    * 采集模块中数据格式：1212|121|1212|
    *  String line = "xx|xx|x";
    * line.split("[|]")
    *  路径中使用正则表达式，不符合语法要求，提示404错误
    * */
    //@RequestMapping("/test4/{id:[0-9]}")
    @RequestMapping("/test4/{id:\\d+}")
    public String test4(){
        return "hello";
    }


}
