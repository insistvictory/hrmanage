<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/20
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>职位详情</title>
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
<form action="${pageContext.request.contextPath}/admin/updateJob" method="post">
    <input type="hidden" name="id" value="${requestScope.job.id}">
    <input type="hidden" name="createTime" value="${requestScope.job.createTime}">
    <input type="hidden" name="deptId" value="${requestScope.job.deptId}">
    <table>
        <tr>
            <td>职位名称:</td>
            <td><input type="text" name="name" value="${requestScope.job.name}"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="修改"></td>
        </tr>
    </table>
</form>
</body>
</html>
