package com.briup.bean;

import com.briup.web.controller.DateToStringSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author lining
 * @Date 2022/10/12
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private int id;
    private String name;
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:dd")//处理表单请求参数时间转换
    //@JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    //@JsonSerialize(using = DateToStringSerializer.class) //只能解决响应对象的json转换
    private Date dob;
    public String test(){
        System.out.println("spEl表达式调用方法");
        return "tom";
    }
}
