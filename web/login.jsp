<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/12
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户登录界面</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <style type="text/css">
        body{
            background-image: url("${pageContext.request.contextPath}/img/4.jpg");
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-attachment: fixed;
        }
    </style>
    <script>
        $(function() {
            $("#sub").click(function () {
                var name = $("#name").val();
                if (name == "") {
                    alert("用户名不能为空");
                    return false;
                }
                var password = $("#psd").val();
                if (password == "") {
                    alert("密码不能为空");
                    return false;
                }
            })
        })
    </script>
</head>
<body>
<div align="center"style="margin-top:100px">
    <form action="${pageContext.request.contextPath}/user/findUserByNameAndPassword" method="post">
        <h1>登录</h1>
        <input id="name" type="text" name="name" placeholder="用户名"><br><br><br>

        <input id="psd" type="text" name="password" placeholder="密码"><br><br><br>
        <input id="sub" type="submit" value="登录"><br><br><br>

        <span style="color: red ">快来加入我们吧</span><a href="regist.jsp"><span style="font-style:italic">注册</span></a>
    </form>
</div>
</body>
</html>
