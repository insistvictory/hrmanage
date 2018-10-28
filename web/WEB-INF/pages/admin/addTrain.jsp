<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/20
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>增加培训</title>
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
<div>
    <form action="${pageContext.request.contextPath}/admin/addTrain" method="post">
    <table>
        <tr>
            <td colspan="2">培训--新增</td>
        </tr>
        <tr>
            <td>培训名称</td>
            <td><input id="t1" type="text" name="trainContext"></td>
        </tr>
        <tr>
            <td>培训时间</td>
            <td><input id="t2" type="date" name="trainTime"></td>
        </tr>
        <tr>
            <td>培训时长</td>
            <td><input id="t3" type="number" name="sumTime">天</td>
        </tr>
        <tr>
            <td>培训部门</td>
            <td>
                <select name="trainDept" id="s1">
                    <c:forEach items="${requestScope.depts}" var="dept">
                            <option>${dept.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td><input type="submit"></td>
            <td><a href="${pageContext.request.contextPath}/admin/trainManage">返回</a></td>
        </tr>
    </table>
    </form>
</div>
</body>
</html>
