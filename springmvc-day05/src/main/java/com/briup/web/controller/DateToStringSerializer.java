package com.briup.web.controller;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author lining
 * @Date 2022/10/14
 * 1.注入到bean对象，由spring自动调用方法
 *   拦截器 适配器
 * 2.写入到其他方法中：jackson手动创建对象调用方法
 *   通过注解的方式表达
 *
 */
public class DateToStringSerializer extends JsonSerializer<Date> {
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        System.out.println("将时间对象转换为时间字符串");
        //1.创建DateFormat对象，
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //2.产生时间字符串
        String dateStr = simpleDateFormat.format(date);
        //3.将字符串写入到Json字符串
        jsonGenerator.writeString(dateStr);
    }
}
