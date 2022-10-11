package com.briup.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取每个请求响应执行时间 end-start=
 * @Author lining
 * @Date 2022/10/11
 */
public class TimeInterceptor implements HandlerInterceptor {
   // private long startTime;//多线程中线程安全问题
    private ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    //继续讨论一个问题：保存每个线程中使用的用户信息 id=1 name=jack age=abc
    //private ThreadLocal<Map<String,Object>> tl = new ThreadLocal();
    //                    Properties
    //         自定义      UserInfo类  id name  age......
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        threadLocal.set(startTime);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long endTime = System.currentTimeMillis();
        System.out.println(request.getRequestURI()+"的执行时间:"+(endTime-threadLocal.get()));
    }
}
