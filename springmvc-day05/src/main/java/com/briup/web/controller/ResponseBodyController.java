package com.briup.web.controller;

import com.briup.utils.Result;
import com.briup.bean.Student;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * 方法的返回值对象转换为json格式数据
 * @Author lining
 * @Date 2022/10/14
 *
 * RESTFUl风格的路径
 *    GET  /student/1
 *    POST /student
 *    PUT  /student
 *    DELETE /student/2
 *
 */
@RestController //@Controller+@ResponseBody
@RequestMapping("/response")
public class ResponseBodyController {
    @GetMapping("/{id}")
    public String[] find(){
        //返回的数组类型
        return new String[]{"a","b","c"};
    }

    @PostMapping//  POST /response
    public List<Student> add(){
        //[{},{},{}]
        Student s = new Student(1, "jack", new Date());
        Student s2 = new Student(1, "jack", new Date());
        return Arrays.asList(s,s2);
    }
    @PutMapping
    public Map<String,Student> update(){
        Student s = new Student(1, "tom", new Date());
        Student s2 = new Student(1, "tom", new Date());
        Map<String, Student> map = new HashMap<>(30);
        map.put("1",s);
        map.put("2",s2);
        return map;
    }
    @DeleteMapping("/{id}")
    public Student delete(){
        return null;
    }
    /*  code 后台程序是否正确执行
             0 表示错误   1 表示成功
        msg  提供框显示的数据
        data 表示用户的返回的数据，展示
        {“code”:1,"msg":"查询成功","data":["a","b","c"]}


        希望返回格式为
     */
    //如何提供返回类型，实现返回的数据格式为上面
    //{"code":1,"msg":"查询成功","data":["a","b","c"]}
    @GetMapping("/result")
    public Map<String,Object> findAll(){
        //1.SpringMVC自动  利用jackson.jar中提供的方法实现一个java对象转换为json字符串
        HashMap<String, Object> result = new HashMap<>();
        result.put("code",1);
        result.put("msg","查询成功");
        result.put("data",new String[]{"A","B"});
        return result;
    }
    //查询Student List<Student>学生信息成功
    public Result<Student> findById(){
        Student s = new Student();
        //通过封装创建对象的过程简化输入参数
        //return Result.success(s);
        return new Result<>(1,"查询成功",s);
    }
    @GetMapping("/servlet")
    public void test3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //跳转到项目的a资源  项目根目录
        //request.getRequestDispatcher("/response/result").forward(request,response);
        // 服务器根目录：请观察不同的效果
        response.sendRedirect("/response/result");
        //  根目录有2种： 1.项目根目录:servlet+页面 2.服务器根目录: 放多个项目的路径
    }
}
