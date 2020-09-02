<%--
  Created by IntelliJ IDEA.
  User: demon
  Date: 2020/9/1
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Annotation</title>
</head>
<body>
<a href="testRequestParam?username=demon">@RequestParam</a>
<h3>@RequestBody</h3>
<form action="testRequestBody" method="post">
    书名：<input type="text" name="bName"/><br/>
    作者：<input type="text" name="bAuthor"/><br/>
    <input type="submit" value="提交">
</form>
<a href="testPathVariable/7">@PathVariable</a><br/>
<a href="testRequestHeader">@RequestHeader</a><br/>
<a href="testCookieValue">@CookieValue</a><br/>
<h3>@ModelAttribute</h3>
<form action="testModelAttribute" method="post">
    ID：<input type="text" name="bId"/><br/>
    作者：<input type="text" name="bAuthor"/><br/>
    <input type="submit" value="提交">
</form>
<h3>SessionAttribute</h3>
<a href="testPut">存入</a>
<a href="testGet">获取</a>
<a href="testClean">清除</a>
</body>
</html>
