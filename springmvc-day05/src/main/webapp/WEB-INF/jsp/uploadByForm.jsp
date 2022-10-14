<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>表单上传文件</title>
</head>
<body>
    <h1>表单上传文件</h1>
    <form action="/upload/form" method="post" enctype="multipart/form-data">
        <input type="file" name="file"><br>
        <input type="file" name="file"><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>