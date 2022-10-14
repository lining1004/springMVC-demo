<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ajax文件上传</title>
    <script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="/js/ajaxfileupload.js"></script>
    <script type="text/javascript">
        $(function () {
            $("input:button").on("click", function () {
                if (!$("#myfile").val()) {
                    alert("请选择上传文件");
                    return;
                }
                ajaxFileUpload();
            });
        });

        function ajaxFileUpload() {
            $.ajaxFileUpload(
                {
                    url: '/upload/ajax',
                    fileElementId: 'myfile',
                    dataType: 'text',
                    success: function (data) {
                        $("input:file").val("");
                        $("#sp").html(data).css("color", "green");
                    },
                    error: function (data) {
                        $("#sp").html(data).css("color", "red");
                    }
                }
            );
        }
    </script>
</head>
<body>
<h1>ajax上传</h1>
<input id="myfile" type="file" name="myfile"><br>
<input type="button" value="上传"><br>
<span id="sp"></span>
</body>
</html>