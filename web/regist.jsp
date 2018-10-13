<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/12
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>游客注册界面</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <style type="text/css">
        body{
            background-image: url("${pageContext.request.contextPath}/img/2.jpg");
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-attachment: fixed;
        }
    </style>

</head>
<body>
<form  action="${pageContext.request.contextPath}/user/addUser" method="post">
    <h3>注册</h3>
    <input type="text" name="name"><br>
    <input type="text" name="password"><br>
    <input type="text" name="password2"><br>
    <input type="submit" value="注册"><br>
    <input type="button" value="取消"><br>
</form>
</body>
</html>
