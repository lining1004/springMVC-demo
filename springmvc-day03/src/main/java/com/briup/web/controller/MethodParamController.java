package com.briup.web.controller;

import com.briup.bean.Student;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 通过类实现设置不同类型的参数在控制器的方法中
 * @Author lining
 * @Date 2022/10/12
 */
@Controller
@RequestMapping("/methodParam")
public class MethodParamController {
    @RequestMapping("/test")
    public ModelAndView test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        System.out.println(inputStream);

        //使用模型视图对象返回jsp页面
        return new ModelAndView("hello");
    }
    @RequestMapping("/test2")
    public void test(InputStream in, OutputStream out){
        //tomcat创建输入流和输出流对象
        System.out.println(in);
        System.out.println(out);
    }
    /*
      1.换不同的浏览器后，导致获取session对象不同
      2.火狐浏览器 第二次发送请求，使用还是上一次session对象
      3.能不能实现每次访问都是新的session对象
         通过代码销毁已经创建好的session.
         每次新建一个Session对象
          手动销毁 session.invalidate();  自动销毁
         每次请求发送时，不允许发送cookie jsessionid


     */
    @RequestMapping("/session")
    public String test3(HttpSession session){
        System.out.println("sessionId="+session.getId());
        //创建session对象 request.getSession();
        //利用session 在一次会话中可以保存数据
        session.setAttribute("username","jack");
        return "hello";
    }
    @RequestMapping("/test4")
    public String test4(WebRequest webRequest, NativeWebRequest nativeWebRequest){
        //访问数据：request session context
        Object username = webRequest.getAttribute("username", WebRequest.SCOPE_SESSION);
        System.out.println("获取session范围参数值："+username);
        System.out.println(webRequest == nativeWebRequest);
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse respose = nativeWebRequest.getNativeResponse(HttpServletResponse.class);
        //native   一个方法没有方法体, 实现通过其他语言实现的
        return "hello";
    }
    /*
      利用springMVC 实现将请求参数封装到方法参数的对象中
        POST /test5
        content_type
        id=1&name=jack
     */
    @RequestMapping("/test5")
    public String test5(Student stu){
        //请求参数名字与对象属性名相同，自动封装
        System.out.println(stu);
        /*
            当自动转换的参数类型为时间类型 ：String -Date类型
            使用注解标识当前字符串转换的规则 @DateTimeFormat
            yyyy-MM-dd
         */
        return "hello";
    }
    @RequestMapping("/test6")
    public String test6(Model model, ModelMap modelMap, Map map){
        //3个参数对象都是同一个对象
        System.out.println(model == modelMap);
        System.out.println(map == modelMap);
        map.put("username","lisi");
        return "hello";
    }
    @RequestMapping("/test7")
    public String test7(HttpEntity<String> httpEntity){
        //获取请求信息
        String body = httpEntity.getBody();
        System.out.println("请求体："+body);
        //多个key=value值组成
        HttpHeaders headers = httpEntity.getHeaders();
        Set<Map.Entry<String, List<String>>> entries = headers.entrySet();
        entries.forEach((m)->{
            //遍历获取每个请求头信息
            String key = m.getKey();
            List<String> value = m.getValue();
            System.out.println(key+":"+value);
        });
        return "hello";
    }
    //ResponseEntity 表示响应报文对象
    @RequestMapping("/test8")
    public ResponseEntity test8(){
        //通过提供ResponseEntity 实现构建响应报文
        //响应行  设置响应状态
        HttpStatus status = HttpStatus.OK;
        //响应头
        HttpHeaders headers = new HttpHeaders();
        headers.set("username","zhangsan");
        headers.setContentType(MediaType.TEXT_HTML);
        //空行
        //响应体
        String body = "hello world";
        ResponseEntity<String> response = new ResponseEntity<String>(body,headers,status);
        return response;
    }
}
