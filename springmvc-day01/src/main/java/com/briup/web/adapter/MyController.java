package com.briup.web.adapter;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义处理器接口：
 * 要求每个实现处理器类必须实现该接口
 * @Author lining
 * @Date 2022/10/10
 */
public interface MyController {

    //处理请求和响应对象
   ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
