<%--
  Created by IntelliJ IDEA.
  User: demon
  Date: 2020/9/3
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File Upload</title>
</head>
<body>
<h2>传统文件上传</h2>
<form action="fileuploadTraditional" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"/><br/>
    <input type="submit" value="上传"/>
</form>
<h2>SpringMVC文件上传</h2>
<form action="fileupload" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"/><br/>
    <input type="submit" value="上传"/>
</form>
<h2>跨服务器文件上传</h2>
<form action="fileupload2Server" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"/><br/>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
