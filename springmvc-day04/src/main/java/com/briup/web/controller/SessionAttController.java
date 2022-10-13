package com.briup.web.controller;

import com.briup.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

/**
 * @Author lining
 * @Date 2022/10/13
 * //  SessionAttributes 不能与参数上注解ModelAttribute 同时使用  ？？?
 *
 */
@SessionAttributes("username") //从model中获取username=jack存放在session对象
@Controller
@RequestMapping("/sessionAtt")
public class SessionAttController {
    @ModelAttribute("username")
    public String method(){
        //在模型中保存数据：username=jack
        return "jack";
    }
    @RequestMapping("/test2")
    public String test2(Model model, @ModelAttribute("studenName") String name){
        //默认从session中获取key为name的值
        System.out.println(model);
        System.out.println(name);
        return "hello";
    }
    @RequestMapping("/test")
    public String test(HttpSession session){
        Object username = session.getAttribute("username");
        System.out.println("session对象中保存username: "+username);
        return "hello";
    }
    @PostMapping("/addStudent")
    public String addStudent(Student s){
        System.out.println(s);
        return "hello";
    }
}
