<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/20
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>员工查看个人信息</title>
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
<form action="${pageContext.request.contextPath}/employee/updateEmployee" method="post">
    <table border="1" cellpadding="5px" cellspacing="0">
        <input type="hidden" name="uid" value="${requestScope.employee.uid}">
        <input type="hidden" name="id" value="${requestScope.employee.id}">
        <input type="hidden" name="nowStatus" value="${requestScope.employee.nowStatus}">
        <tr>
            <td colspan="4" align="center">个人信息</td>
        </tr>
        <tr>
            <td>真实姓名</td>
            <td><input type="text" name="name" value="${requestScope.employee.name}" readonly="readonly"></td>
            <td>性别</td>
            <td>
                <input type="text" name="gender" value="${requestScope.employee.gender}" readonly="readonly">
            </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input  type="number" name="age" value="${requestScope.employee.age}" readonly="readonly"></td>
            <td>学历</td>
            <td><input type="text" name="education" value="${requestScope.employee.education}" readonly="readonly"></td>
        </tr>
        <tr>
            <td>联系方式</td>
            <td><input type="text" name="tel" value="${requestScope.employee.tel}"></td>
            <td>e-mail</td>
            <td><input type="text" name="email" value="${requestScope.employee.email}"></td>
        </tr>
        <tr>
            <td>应聘职位</td>
            <td>
                <input type="text" name="dept" value="${requestScope.employee.dept}" readonly="readonly">
                <input type="text" name="job" value="${requestScope.employee.job}" readonly="readonly">
            </td>

            <td>政治面貌</td>
            <td>
                <input type="text" name="politicalStatus" value="${requestScope.employee.politicalStatus}" readonly="readonly">
            </td>
        </tr>
        <tr>
            <td>入职时间:</td>
            <td><input type="datetime" name="entryTime" value="<f:formatDate value="${requestScope.employee.entryTime}" pattern="yyyy-MM-dd hh:mm:ss"></f:formatDate>" readonly="readonly"></td>
            <td>爱好</td>
            <td><input type="text" name="hobby" value="${requestScope.employee.hobby}"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="保存"></td>

            <td colspan="2" align="center"><a href="${pageContext.request.contextPath}/employee/middle">返回</a></td>
        </tr>
    </table>
</form>
</body>
</html>
