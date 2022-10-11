package com.briup.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1.创建拦截器，必须实现接口
 * 2.必须设置拦截规则：
 *  基于映射器对象
 *  基于拦截的路径
 * @Author lining
 * @Date 2022/10/11
 */
public class MyHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        String name = request.getParameter("username");
        if("tom".equals(name)){
            //告诉用户，tom无法访问系统
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("tom用户无法访问系统");
            return  false;//表示拦截
        }
        return true;//false 没有通过拦截 true :通过拦截器，继续调用controller中方法
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //当处理器调用方法结束后，调用该方法
        modelAndView.addObject("userId",202001);
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //调用模型渲染视图后 调用该方法
        System.out.println("afterCompletion");
        /*if(ex != null){
            System.out.println(ex.getMessage());
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("服务器内部错误，请联系管理员");
        }*/
    }
}
