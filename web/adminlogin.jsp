<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/17
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>管理员登录</title>
</head>
<body>

<div align="center"style="margin-top:100px">
    <form action="${pageContext.request.contextPath}/admin/findAdminByNameAndPassword" method="post">
        <h1>登录</h1>
        <input id="name" type="text" name="name" placeholder="用户名"><br><br><br>

        <input id="psd" type="text" name="password" placeholder="密码"><br><br><br>
        <input id="sub" type="submit" value="登录"><br><br><br>

    </form>
</div>
</body>
</html>
