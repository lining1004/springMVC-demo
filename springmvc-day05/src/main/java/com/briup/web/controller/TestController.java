package com.briup.web.controller;

import com.briup.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author lining
 * @Date 2022/10/14
 */
@RestController  //@Controller+@ResponseBody
//@ResponseBody  //所有的方法的返回值放在响应体内容中
//@Controller
@RequestMapping("/test")
public class TestController {
    @GetMapping("/url")
   // @ResponseBody //返回值存放在响应体内容中，不作为视图名
    public Student method(){
        return new Student(1,"jack",new Date());
    }
    @PostMapping("/url")
   // @ResponseBody
    public Student method2(){
        return new Student(1,"jack",new Date());
    }
}
