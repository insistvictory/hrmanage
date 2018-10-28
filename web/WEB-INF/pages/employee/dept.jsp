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
    <title>员工查看部门职位</title>
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
        <table>
            <tr>
                <td>部门</td>
                <td>职位</td>
            </tr>
            <c:forEach items="${requestScope.depts}" var="dept">
                <tr>
                    <td>${dept.name}</td>
                    <td><a href="employee/findJobsByDeptName?deptName=${dept.name}"> 职位</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="2"><a href="employee/middle">返回</a></td>
            </tr>
        </table>
</div>
</body>
</html>
