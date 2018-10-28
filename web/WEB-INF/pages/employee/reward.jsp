<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/21
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <title>员工查看自己奖惩</title>
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
    <table border="1px" cellspacing="0px" cellpadding="10px">
        <tr>
            <td>时间</td>
            <td>奖惩金额</td>
            <td>奖惩原因</td>
        </tr>
        <c:forEach items="${requestScope.rewardPublishes}" var="rewardPublish">
            <tr>
                <td><f:formatDate value="${rewardPublish.rpTime}" pattern="yyyy-MM-dd"></f:formatDate></td>
                <td>${rewardPublish.money}</td>
                <td>${rewardPublish.cause}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="employee/middle">返回</a>
</body>
</html>
