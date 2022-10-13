package com.briup.web.controller;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author lining
 * @Date 2022/10/13
 */
public class DateToStringSeri extends JsonSerializer<Date> {

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider){
        //1.时间对象和字符串转换问题：
        Date datetime = new Date();
        //1.使用java.text.SimpleDataForamat();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //2.调用方法实现对象转换
        String str = dateFormat.format(datetime);
        //3.字符串对象转换时间对象
        try {
            Date datetime2 = dateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
