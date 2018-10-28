<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/24
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        body{
            background-image: url("${pageContext.request.contextPath}/img/5.jpg");
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-attachment: fixed;
        }
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#dd").hide();
            $("#hef").click(function () {
                    $("#dd").show();
                return false;
            })
            $("#sub").click(function () {
                var a = $("#rs").val();
                if (a == "") {
                    alert("异议缘由不能为空");
                    return false;
                }
                var b = $("#num").val();
                if (b == "") {
                    alert("出入值不能为空");
                    return false;
                }
            })
        })
    </script>
</head>
<body>
    <div align="center">
        <table border="1px" cellspacing="0px" cellpadding="10px">
            <tr>
                <td>总工资</td>
                <td>基本工资</td>
                <td>奖惩工资</td>
                <td>社保</td>
                <td>上月异议工资</td>
                <td>是否有意义异议</td>
            </tr>

            <tr>
                <td>${requestScope.salary.sumSalary}</td>
                <td>${requestScope.salary.baseSalary}</td>
                <td>${requestScope.salary.rewardSalary}</td>
                <td>${requestScope.salary.society}</td>
                <td>${requestScope.salary.argSalary}</td>
                <td><a href="#" id="hef">异议</a></td>
            </tr>
            <tr>
                <td colspan="6"><a href="${pageContext.request.contextPath}/employee/backTurn">返回</a></td>
            </tr>
        </table>
    </div>
    <div id="dd">
        <form action="${pageContext.request.contextPath}/employee/AddArgument">
            <input type="hidden" name="salaryId" value="${requestScope.salary.id}">
            <table border="1px" cellspacing="0px" cellpadding="10px">
                <tr>
                    <td>异议</td>
                    <td><input type="text" name="reason" id="rs"></td>
                </tr>
                <tr>
                    <td>出入金额</td>
                    <td><input type="number" name="argSalary" id="num"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" id="sub"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
