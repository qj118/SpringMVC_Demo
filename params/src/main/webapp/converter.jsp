<%--
  Created by IntelliJ IDEA.
  User: demon
  Date: 2020/9/1
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Converter</title>
</head>
<body>
<h3>自定义类型转化器</h3>
<form action="saveChild" method="post">
    姓名：<input type="text" name="childName"/><br/>
    年龄：<input type="text" name="childAge"/><br/>
    生日：<input type="text" name="birthday"/><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
