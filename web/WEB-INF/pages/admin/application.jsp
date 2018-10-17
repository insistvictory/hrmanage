<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/16
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <title>应聘消息</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
</head>
<body>
    <div>
        <table border="1px" cellpadding="5px" cellspacing="0px">
            <tr>
                <td>应聘者</td>
                <td>投递时间</td>
                <td>查看状态</td>
                <td>面试状态</td>
                <td colspan="2">操作</td>
            </tr>
                <c:forEach items="${sessionScope.applications}" var="application">
                    <tr>
                        <td>${application.id}</td>
                        <td><f:formatDate value="${application.applyTime}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
                        <td>${application.resumeStatus}</td>
                        <td>面试状态</td>
                        <td><a href="admin/searchDelivererDetail?id=${application.resumeId}">查看</a></td>
                        <td><a href="">删除</a></td>
                    </tr>
                </c:forEach>
        </table>
    </div>
</body>
</html>
