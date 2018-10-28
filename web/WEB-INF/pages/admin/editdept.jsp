<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/18
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改部门信息</title>
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
<form action="${pageContext.request.contextPath}/admin/editDept" method="post">
    <input type="hidden" name="id" value="${requestScope.dept.id}">
    <input type="hidden" name="createTime" value="${requestScope.dept.createTime}">
    <table>
        <tr>
            <td>部门名称:</td>
            <td><input type="text" name="name" value="${requestScope.dept.name}"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="修改"></td>
        </tr>
    </table>
</form>
</body>
</html>
