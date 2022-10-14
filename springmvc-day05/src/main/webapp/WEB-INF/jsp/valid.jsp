<%--
  Created by IntelliJ IDEA.
  User: lining
  Date: 2022/10/13
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>valid.jsp</title>
</head>
<body>
<sf:form action="/valid/test" method="post" modelAttribute="teacher">
    <sf:label path="name">用户名:</sf:label>
    <sf:input path="name"/>
    <sf:errors path="name" cssStyle="color:red"></sf:errors><br>
    <sf:label path="age"> 年 龄:</sf:label>
    <sf:input path="age"/>
    <sf:errors path="age" cssStyle="color:red"></sf:errors><br>
    <sf:label path="dob"> 生 日:</sf:label>
    <sf:input path="dob"/>
    <sf:errors path="dob" cssStyle="color:red"></sf:errors><br>
    <input type="submit" value="提交"/>
</sf:form>
</body>
</html>