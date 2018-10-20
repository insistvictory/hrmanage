<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/18
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <title>员工界面</title>
</head>
<body>
个人信息
我的考勤
修改密码
我的奖惩
部门职位
其它
我的薪资
<button><a href="login.jsp">退出</a></button><br>
<button><a href="employee/working">上班打卡</a></button><br>
<button><a href="employee/worked">下班打卡</a></button>
</body>
</html>
