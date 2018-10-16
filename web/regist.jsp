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
    <script type="text/javascript">
        $(function () {
            $("#lname").blur(function () {
                if ($(this).val()==""){
                    $("#spn1").text("用户名不能为空")
                    $("#sub").attr("disabled",true);
                }else {
                    var url="${pageContext.request.contextPath}/user/validateName";
                    var ags={name:$(this).val()};
                    $.post(url,ags,function (data) {
                        if (data=="ok"){
                            $("#spn1").text("用户名可用")
                            $("#sub").attr("disabled",false)
                        }else {
                            $("#spn1").text("用户名已存在")
                            $("#sub").attr("disabled",true);
                        }
                    })
                }
            })
            $("#psd1").blur(function () {
                if($(this).val()=="") {
                    $("#spn").text("密码不能为空");
                    $("#sub").attr("disabled", true);
                }else {
                    $("#spn").empty();
                    $("#sub").attr("disabled", false);
                }
            })
            $("#psd2").blur(function () {
                if($(this).val()!=$("#psd1").val()){
                    $("#sp").text("密码不匹配");
                    $("#sub").attr("disabled",true);
                }else {
                    $("#sp").empty();
                    $("#sub").attr("disabled",false);
                }
            })
        })
    </script>

</head>
<body>
<form  action="${pageContext.request.contextPath}/user/addUser" method="post">
    <h3>注册</h3>
    <input id="lname" type="text" name="name"><span id="spn1"></span><br>
    <input id="psd1" type="text" name="password"><span id="spn"></span><br>
    <input id="psd2" type="text" name="password2"><span id="sp"></span><br>
    <input id="sub" type="submit" value="注册"><br>
   <%-- <input type="button" value="取消"><br>--%>
</form>
</body>
</html>
