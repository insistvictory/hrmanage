<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/12
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>游客界面</title>
</head>
<body>

          <a href="${pageContext.request.contextPath}/user/lookResume?flag=a&id=${requestScope.user.id}">查看简历</a>
</body>
</html>
