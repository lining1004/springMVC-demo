<%--
  Created by IntelliJ IDEA.
  User: lining
  Date: 2022/10/10
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--引入静态资源--%>
    <link href="/css/style.css" rel="stylesheet">
    <title>测试</title>
</head>
<body>
    <%--
     el表达式获取的数据来自ModelAndView对象
     模型数据
        将数据渲染到指定的视图中


    --%>
    <h3>hello ${username }</h3>
    <h3>hello ${userId }</h3>
</body>
</html>
