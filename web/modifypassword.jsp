<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/15
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改密码</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#sub").attr("disabled",true)
            $("#original").blur(function () {
                $("#spn1").empty()
                var url="${pageContext.request.contextPath}/user/validatePassword";
                var ags={password:$(this).val()};
                $.post(url,ags,function (data) {
                    if (data=="error"){
                        $("#spn1").text("密码错误")
                    }
                })
            })
            $("#newpsd").blur(function () {
                $("#spn3").empty();
                if($(this).val()=="") {
                    $("#spn3").text("密码不能为空");
                }
            })
            $("#checkpsd").blur(function () {
                $("#spn2").empty()
                if($(this).val()!=$("#newpsd").val()){
                    $("#spn2").text("两次密码不匹配")
                    $("#sub").attr("disabled",true)
                }else {
                    $("#sub").attr("disabled",false)
                }
            })
           /* $("#sub").click(function () {
                if($("newpsd").val()==""){
                    $("#spn3").text("新密码不能为空");
                    return false;
                }
                if($("original").val()==""){
                    $("#spn1").text("原始密码不能为空");
                    return false;
                }
            })*/
        })

    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/updatePassword" method="post">
    <table>
        <input type="hidden" name="id" value="${param.id}">
        <tr>
            <td>原密码:<input id="original" type="text"><span id="spn1"></span></td>
        </tr>
        <tr>
            <td>新密码:<input id="newpsd" type="text"><span id="spn3"></span></td>
        </tr>
        <tr>
            <td>密码确认:<input id="checkpsd" type="text" name="newPassword"><span id="spn2"></span></td>
        </tr>
        <tr>
            <td><input id="sub" type="submit" value="确认修改"></td>
        </tr>
    </table>
</form>

</body>
</html>
