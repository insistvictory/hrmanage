<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/25
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</head>
<body>
    <div align="center">
        <table border="1px" cellspacing="0px" cellpadding="10px">
            <tr>
                <td>员工</td>
                <td>总工资</td>
                <td>基本工资</td>
                <td>奖惩工资</td>
                <td>社保</td>
                <td>上月异议工资</td>
            </tr>

            <tr>
                <td>${requestScope.salary.eid}</td>
                <td>${requestScope.salary.sumSalary}</td>
                <td>${requestScope.salary.baseSalary}</td>
                <td>${requestScope.salary.rewardSalary}</td>
                <td>${requestScope.salary.society}</td>
                <td>${requestScope.salary.argSalary}</td>
            </tr>
        </table>
    </div>
</body>
</html>
