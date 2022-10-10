package com.briup.web.controller;

import com.briup.web.adapter.MyController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义处理器实现自定义的接口
 * @Author lining
 * @Date 2022/10/10
 */
public class StudentController implements MyController {
    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("username","tom");
        return mv;
    }
}
