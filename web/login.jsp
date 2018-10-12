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
    <title>游客登录界面</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <style type="text/css">
        body{
            background-image: url("${pageContext.request.contextPath}/img/1.png");
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-attachment: fixed;
        }
    </style>
    <script>
        $(function(){
            $("#name").blur(function(){
                var name= $("#name").val();
                if(name==""){
                    alert("用户名不能为空")
                }
            })
            $("#password").blur(function(){
                var password= $("#password").val();
                if(password==""){
                    alert("密码不能为空")
                }
            })
        })
    </script>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/findUserByNameAndPassword" method="post">
        <h3>登录</h3>
        <input id="name" type="text" name="name"><br>
        <input id="password" type="text" name="password"><br>
        <input type="submit" value="登录"><br>
        <input type="button" value="取消"><br>
        <span style="color: red">快来加入我们吧</span><a href="regist.jsp"><span style="font-style:italic">注册</span></a>
    </form>
</body>
</html>
