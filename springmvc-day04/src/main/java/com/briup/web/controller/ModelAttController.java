package com.briup.web.controller;

import com.briup.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * 数据绑定中模型数据绑定操作
 * 1.使用在方法上
 * @Author lining
 * @Date 2022/10/13
 */
@SessionAttributes("studentNames")
@Controller
@RequestMapping("/modelAtt")
public class ModelAttController {
    @ModelAttribute("studentName")
    public String method(){
        //将方法的返回值jack字符串绑定的model对象上，
        //返回的数据名称为返回类型的首字符小写
        System.out.println("自动调用方法实现数据绑定");
        return "jack";
    }
    @ModelAttribute("studentNames")
    public List<String> method2(){
        System.out.println("自动调用方法实现数据绑定2");
        //模型数据：{string=jack, stringList=[A, B, C]}
        return Arrays.asList("A","B","C");
    }
    ///url?id=1&name=jack
    //方法的引入类型参数对象默认存放在model对象中
    @RequestMapping("/test")
    public String test(Model model, Student s){
        System.out.println("模型数据："+model);
        return "hello";
    }
    //当方法参数类型为基本类型/字符串类型。不会绑定model数据中
    @RequestMapping("/test2")
    public String test2(Model model,int id,String name){
        System.out.println("模型数据："+model);
        return "hello";
    }
    //实现将方法的字符串类型的参数值放入model数据中
    @RequestMapping("/test3")
    public String test3(Model model,@ModelAttribute("name") String name){
        System.out.println("模型数据："+model);
        return "hello";
    }
    //
    @RequestMapping("/test4")
    public String test4(Model model,@ModelAttribute("studentName") String name){
        //可以实现从模型对象中读取studentName的value值 绑定到方法的参数上
        System.out.println("模型数据："+model);
        System.out.println("方法参数值name:"+name);
        return "hello";
    }
    @RequestMapping("/test5")
    public String test5(Model model,@ModelAttribute("studentName") @RequestParam(value = "studentName",required = false) String studentName){
        //可以实现从模型对象中读取studentName的value值 绑定到方法的参数上
        System.out.println("模型数据："+model);
        System.out.println("方法参数值name:"+studentName);
        return "hello";
    }
    @RequestMapping("/test6")
    public String test6(HttpSession session){
        Object list = session.getAttribute("studentNames");
        System.out.println(list);
        return "hello";
    }
}
