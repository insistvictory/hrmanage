<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/12
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>招聘信息</title>
    <style type="text/css">
        body{
            background-image: url("${pageContext.request.contextPath}/img/5.jpg");
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-attachment: fixed;
        }
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
</head>
<body>
<div>
    <table border="1px" cellpadding="10px" cellspacing="0px">
        <tr>
            <td>查看详情</td>
            <td>公司</td>
            <td>职位</td>
            <td>地址</td>
            <td>薪资</td>
            <td>发布时间</td>
        </tr>
        <c:forEach items="${requestScope.recruitInfos}" var="recruitInfo">
            <tr>
                <td><a href="${pageContext.request.contextPath}/user/findRecruitInfo?id=${recruitInfo.rid}">☆☆</a></td>
                <td>${recruitInfo.company}</td>
                <td>${recruitInfo.job.name}</td>
                <td>${recruitInfo.address}</td>
                <td>${recruitInfo.salary}</td>
                <td><f:formatDate value="${recruitInfo.pubdate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/user/backTurn">返回</a>
</div>
</body>
</html>

