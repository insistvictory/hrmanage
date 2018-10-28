<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/23
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <td>姓名</td>
                <td>电话</td>
                <td>邮箱</td>
            </tr>
            <c:forEach items="${requestScope.employees}" var="employee">
                <c:if test="${employee.nowStatus eq '在职'}">
                    <tr>
                        <td>${employee.name}</td>
                        <td>${employee.tel}</td>
                        <td>${employee.email}</td>
                    </tr>
                </c:if>
            </c:forEach>
            <tr>
                <td colspan="3"><a href="${pageContext.request.contextPath}/employee/lookDepts">返回</a></td></tr>
        </table>
    </div>
</body>
</html>
