package com.briup.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author lining
 * @Date 2022/10/11
 */
public class ThreadLocalInterceptor implements HandlerInterceptor {
    //如何实现线程安全操作？ 画图描述ThreadLocal对象如何实现线程安全？？ 读源码
    private ThreadLocal<String> threadLocal = new ThreadLocal<>();//多个线程所共享数据：
    // get    set

    public ThreadLocalInterceptor() {
        System.out.println("创建的是ThreadLocalInterceptor拦截器");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String threadName = Thread.currentThread().getName();
        System.out.println("调用拦截器的线程名称："+threadName);
        //使用线程设置name值
        threadLocal.set(threadName);
        System.out.println(threadName+"setName="+threadName);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Thread.sleep(10000);
        //通过让当前线程休眠，实现其他线程访问共享数据name
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //通过线程获取到该name值
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName+" getName="+threadLocal.get());
    }
}
