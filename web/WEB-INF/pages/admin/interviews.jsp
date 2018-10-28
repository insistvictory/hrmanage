<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/22
  Time: 1:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>管理员查看面试消息</title>
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
    <table cellspacing="0px" cellpadding="20px" border="1px" >
        <tr>
            <td>应聘者(简)</td>
            <td>面试时间</td>
            <td>操作</td>
        </tr>
        <c:if test="${!empty requestScope.interviews}">
            <c:forEach items="${requestScope.interviews}" var="interview">
                <tr>
                    <td>${interview.applyId}</td>
                    <td><f:formatDate value="${interview.interviewTime}" pattern="yyyy-MM-dd hh:mm:ss"></f:formatDate></td>
                    <td><a href="${pageContext.request.contextPath}/admin/searchDetail?aid=${interview.applyId}&iid=${interview.id}">面试</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
<a href="${pageContext.request.contextPath}/admin/middle">返回</a>
</div>
</body>
</html>
