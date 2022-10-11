package com.briup.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 结论： 非线程安全问题
 * 1.必须是在多线程的场景下进行。
 * corejava :main线程  jvm多线程 gc线程
 * java web :tomcat提供多线程的环境,调用拦截器和处理器方法使用同一个线程
 * 2.多个线程访问同一个数据时，
 *   A线程影响B线程的数据
 *   A线程获取B线程的数据
 *
 * @Author lining
 * @Date 2022/10/11
 */
public class TestInterceptor implements HandlerInterceptor {
    private String name;//多个线程所共享
    public TestInterceptor() {
        System.out.println("创建的是TestInterceptor拦截器");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String threadName = Thread.currentThread().getName();
        System.out.println("调用拦截器的线程名称："+threadName);
        //使用线程设置name值
        this.name = threadName;
        System.out.println(threadName+"setName="+this.name);
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
        System.out.println(threadName+" getName="+this.name);
    }
}
