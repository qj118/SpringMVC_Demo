<%--
  Created by IntelliJ IDEA.
  User: demon
  Date: 2020/9/1
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Params</title>
</head>
<body>
<a href="testSimple?username=demon&password=123">简单参数</a><br/>
<h3>表单</h3><br/>
<form action="saveAccount" method="post">
    账户名：<input type="text" name="accountName"/><br/>
    账户id：<input type="text" name="accountId"/><br/>
    余额：<input type="text" name="balance"/><br/>
    用户名：<input type="text" name="user.username"/><br/>
    密码：<input type="text" name="user.password"/><br/>
    <br/>
    子用户姓名：<input type="text" name="list[0].childName"><br/>
    子用户年龄：<input type="text" name="list[0].childAge"><br/>
    <br/>
    子用户姓名：<input type="text" name="map['one'].childName"><br/>
    子用户年龄：<input type="text" name="map['one'].childAge"><br/>
    <input type="submit" value="提交">
</form>

<a href="getAPI">获取Servlet原生API</a>

</body>
</html>
