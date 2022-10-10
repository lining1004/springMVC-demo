package com.briup.web.adapter;

import lombok.extern.log4j.Log4j;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义处理器适配器
 * springMVC进行创建对象 调用方法
 * 面向接口编程，是否是接口类型
 * @Author lining
 * @Date 2022/10/10
 * 扩展： 通过Log4j框架实现日志打印功能
 *       1.创建logger对象 2.调用不同级别的日志方法
 *
 */
@Log4j  //lombok 创建成员变量 实现调用日志方法
public class MyhandlerAdapter implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        log.info("support.....");
        return (handler instanceof MyController);//如果返回值为false 无法继续调用handle
    }

    //spring先调用supports 方法 返回true继续调用handle方法
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("handle.....");
        ModelAndView mv = ((MyController) handler).handleRequest(request, response);
        return mv;//将返回视图和模型数据交给前端控制器
}

    @Override
    public long getLastModified(HttpServletRequest request, Object handler) {
        return 0;
    }
}
