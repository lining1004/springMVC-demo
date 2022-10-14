package com.briup.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author lining
 * @Date 2022/10/14
 */
@Controller
public class ErrorController {
    @GetMapping("/page/test/error")
    public String error(){
        System.out.println(1/0);
        return "hello";
    }
}
