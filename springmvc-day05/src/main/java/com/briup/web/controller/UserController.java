package com.briup.web.controller;

import com.briup.bean.Student;
import com.briup.utils.Result;
import com.briup.utils.ResultCode;
import com.briup.utils.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lining
 * @Date 2022/10/14
 */
@RestController
public class UserController {
    @GetMapping("/login")
    public Result login(String username,String password){
        //考虑重复的key=value 整个程序中使用，所以我使用枚举类
        return ResultUtil.success();
    }
    @GetMapping("/user/{id}")
    public Result findById(@PathVariable String id){
        return ResultUtil.success(new Student());
    }

}
