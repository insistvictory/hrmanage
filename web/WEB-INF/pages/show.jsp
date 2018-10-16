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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <%--<script type="text/javascript">
        $(function () {
            $("#btt").click(function () {
               $("#common").show();
            })
        })
    </script>--%>
</head>
<body>

<a href="${pageContext.request.contextPath}/user/lookResume?flag=a&id=${sessionScope.user.id}">查看简历</a>
<a href="../../modifypassword.jsp?id=${sessionScope.user.id}">修改密码</a>
<a href="${pageContext.request.contextPath}/login.jsp">退出</a>
<hr/>
<%--<div id="common" hidden="hidden">
    <form>
        <table>

        </table>
    </form>
</div>--%>
</body>
</html>

