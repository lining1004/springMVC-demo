package com.briup.bean;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:dd")//处理表单请求参数时间转换
    private Date dob;//出生日期

    public String test(){
        return "tom";
    }
}
