<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/19
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <title>员工管理</title>
</head>
<body>
    <table>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td colspan="4">操作</td>
        </tr>
        <c:forEach items="${requestScope.employees}" var="employee">
            <c:if test="${employee.nowStatus=='在职'}">
                <tr>
                    <td>${employee.id}</td>
                    <td><a href="admin/searchEmployeeById?id=${employee.id}">${employee.name}</a></td>
                    <td><a href="admin/transferOfPersonnel?id=${employee.id}">人事调动</a></td>
                    <td>考勤</td>
                    <td>工资发放</td>
                    <td>开除</td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</body>
</html>
