<%--
  Created by IntelliJ IDEA.
  User: demon
  Date: 2020/9/2
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Response</title>

    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script>
        $(() => {
            $("#btn").click(() => {
                // alert("我弹出来了吗？");
                $.ajax({
                        type: "post",
                        url: "testJson",
                        contentType: "application/json;charset=utf-8",
                        data: '{"bookId": 3, "bookName": "外婆的道歉信", "bookAuthor":"弗雷德里克·巴克曼"}',
                        dataType: "json",
                        success: (data) => {
                            alert(data.bookName);
                        }
                    });
            })
        })
    </script>

</head>
<body>
<a href="getBook">获得一本书（返回值为字符串类型测试）</a>
<br/>
<br/>
<a href="testVoid">ReturnVoid 测试</a>
<br/>
<br/>
<a href="testForward">forword 关键字测试</a>&nbsp;&nbsp;
<a href="testRedirect">redirect 关键字测试</a>
<br/>
<br/>
<a href="testModelAndView">Return ModelAndView 测试</a>
<br/>
<br/>
<button id="btn">发送 ajax 请求</button>
</body>
</html>
