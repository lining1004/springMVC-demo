package com.briup.web.controller;

import com.briup.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

/**
 * @Author lining
 * @Date 2022/10/13
 */
@Controller
@RequestMapping("/value")
@Scope("prototype") //多例 每次请求创建一个controller对象
public class ValueController {
    public ValueController() {
        System.out.println("创建ValueController对象");
    }

    //从IOC容器获取该对象
    @Resource
    private Properties systemProperties;


    //GET  /value/test
    //@RequestMapping(value = "/test",method = RequestMethod.GET)
    @GetMapping("/test")
    public String test(@Value("#{T(Math).random()}") String msg){
        //1.bean对象属性值  #{st.name}
        //2.bean对象的方法的返回值
        //3.systemProperties 的key--value systemProperties['java.vm.name']
        //4.调用非静态方法 st.name.toUpperCase()
        //5.调用静态方法 T(Math).random()
        System.out.println("从ioc容器bean对象获取的信息："+msg);
        return "hello";
    }
    @GetMapping("/test2")
    public String test(){
        //遍历properties对象，获取所有的key
        systemProperties.entrySet().forEach(entry -> {
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key+"="+value);
        });
        return "hello";
    }
    /*

        使用表单发送请求
        时间字符串转换为时间对象时，导致400错误，原因无法解析时间字符串格式
     */
    @PostMapping("/addStudent")
    public String addStudent(Student s){
        System.out.println(s);
        return "hello";
    }
    //只作用于当前处理器的请求参数转换中。
    /*
        时间: 2000-01-01 
        整个程序中： 出生日期  2020-10-10
                   订单日期  2020-10-10 10:10:10
                   new SimpleDataFormat("XXXXXX")


     */
    @InitBinder
    public void StringToDate(WebDataBinder webDataBinder){
        System.out.println("自动处理字符串转换为时间对象");
        //1.创建时间格式对象
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);
        webDataBinder.registerCustomEditor(Date.class,dateEditor);
    }
}
