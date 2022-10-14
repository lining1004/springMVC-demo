package com.briup.web.controller;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间类型转换器 响应信息  请求
 * @Author lining
 * @Date 2022/10/14
 * 1.创建bean对象，被springMVC调用
 */
public class StringToDateConverter implements Converter<String,Date> {

    @Override
    public Date convert(String source){
        System.out.println("时间长度："+source.length());
        //传递参数 1999-01-01    1999-01-01 10:10:10
        /*
            思路1：提供多种匹配模式 当字符串长度不同时，匹配不同的日期格式
            思路2：判断字符串是否符合要求，通过拼接字符串实现
            匹配多种格式
            1999/10/10
            1999-10-10
            1999-10-10 10:10:10
         */
        String pattern = "yyyy-MM-dd HH:mm:ss";
        if(source.length() == 10){
            pattern = "yyyy-MM-dd";
            //source = source+ "00:00:00";
            //pattern.contains("/")  可以解析....
        }
        System.out.println("转换器解决时间类型数据");
        //1.创建format对象
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        //2.生成时间dauix
        Date date = null;
        try {
            date = format.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
