package com.briup.web.controller;

import com.briup.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 请求参数 交互问题
 * @Author lining
 * @Date 2022/10/14
 */
@Controller
@RequestMapping("/request")
public class RequestParamController {
    //默认请求参数名与方法名一致，自动数据绑定，
    // 当请求参数为null  无法转换为基本数据类型
    @GetMapping("/test")
    public String test(Integer pageNum){
        /*
            分页参数  1 2 3 基本数据类型 包装类 字符串类


         */
        //id 学号  A20220101
        System.out.println("pageNum："+pageNum);
        return "hello";
    }
    //发送的数据是多选框数据，/url?like=a&like=b&like=c
    // POST  表单请求  /url   请求体：like=a&like=b
    @RequestMapping("/test2")
    public String test2(String[] like){
        System.out.println(Arrays.toString(like));
        return "hello";
    }
    /*
      接收请求体为json字符串格式的请求
      POST
      contentType:application/json
      ["a","b","c"]
      @RequestBody  只接收json类型的请求数据
     */
    @RequestMapping("/test3")
    public String test3(@RequestBody String[] like){
        System.out.println(Arrays.toString(like));
        return "hello";
    }
    //GET  /url?id=1&name=jack
    //POST /url  application/x-www-form   id=1&name=jack
    //POST/PUT /url application/json {"id":1,"name":"tom"}
    @RequestMapping("/test4")
    public String test4(Student s){
        System.out.println(s);
        return "hello";
    }
    //[{"id":1,"name":"jack"},{"id":2,"name":"tom"}]
    @RequestMapping("/test5")
    public String test5(@RequestBody Student[] students){
        //外部遍历 :for foreach stream流java8
        //Arrays.asList(students).stream();
        //内部 ：Stream<Student> stream = Arrays.stream(students);
        Arrays.stream(students).forEach(s ->{
            System.out.println(s);
        });
        return "hello";
    }
    //[{},{},{}]
    @RequestMapping("/test6")
    public String test6(@RequestBody List<Student> list){
        list.forEach(s -> {
            System.out.println(s);
        });
        return "hello";
    }
    /*
        ArrayList内部如何实现？数组
        System.arrayCopy()
        相同的请求json参数：都可以被数组类型和集合类型参数自动接收
        1.选谁？？？  3个Student
        集合List： 数组长度>3个  对数组的操作 service处理参数
        数组： 长度固定 3个   Arrays

     */
    //{"id":"1"}
    //{"202001":{"id":1,"name":"jack"}}
    //多个对象 s对象 s2对象
    //{"202001":{"id":1,"name":"jack"},
    // "202001":{"id":1,"name":"jack"},
    // "202001":{"id":1,"name":"jack"}}
    //{"202001":{"id":1,"name":"jack"},"202002":{"id":2,"name":"tom"}}
    @RequestMapping("/test7")
    public String test7(@RequestBody Map<String,Student> map){
        System.out.println(map);
        return "hello";
    }

    //类型转换器  S  T

}
