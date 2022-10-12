package com.briup.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author lining
 * @Date 2022/10/12
 */
@Data
public class Student {
    private int id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:dd")//处理表单请求参数时间转换
    private Date dob;//出生日期
}
