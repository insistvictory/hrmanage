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
            background-image: url("${pageContext.request.contextPath}/img/3.jpg");
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-attachment: fixed;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            $("#lname").blur(function () {
                if ($(this).val()==""){
                    $("#spn1").text("用户名不能为空")
                }else {
                    var url="${pageContext.request.contextPath}/user/validateName";
                    var ags={name:$(this).val()};
                    $.post(url,ags,function (data) {
                        if (data=="ok"){
                            $("#spn1").text("用户名可用")

                        }else {
                            $("#spn1").text("用户名已存在")

                        }
                    })
                }
            })
            $("#psd1").blur(function () {
                if($(this).val()=="") {
                    $("#spn").text("密码不能为空");
                }else {
                    $("#spn").empty();
                }
            })
            $("#psd2").blur(function () {
                $("#sp").empty();
                if($(this).val()!=$("#psd1").val()){
                    $("#sp").text("密码不匹配");
                }
            })
            $("#sub").click(function () {
                if($("#lname").val()==""){
                    $("#spn1").text("用户名不能为空");
                    return false;
                }
                if($("#psd1").val()==""){
                    $("#spn").text("密码不能为空");
                    return false;
                }
                if ($("#sp").text()=="密码不匹配"){
                    return false;
                }
                if ($("#spn1").text()=="用户名已存在"){
                    return false;
                }
            })
        })
    </script>

</head>
<body>
<div align="center"style="margin-top:100px">
<form  action="${pageContext.request.contextPath}/user/addUser" method="post">
    <table>
        <tr>
            <td colspan="3" align="center"><h3>注册</h3></td>
        </tr>
        <tr>
            <td>用户名:</td>
            <td><input id="lname" type="text" name="name"></td>
            <td><span id="spn1"></span></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input id="psd1" type="text" name="password"></td>
            <td><span id="spn"></span></td>
        </tr>
        <tr>
            <td>密码确认:</td>
            <td><input id="psd2" type="text" name="password2"></td>
            <td><span id="sp"></span></td>
        </tr>
        <tr>
            <td colspan="3"><input id="sub" type="submit" value="注册"></td>
            <td><a href="${pageContext.request.contextPath}/login.jsp">返回</a></td>
        </tr>
    </table>
</form>
</div>
</body>
</html>
