<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/13
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员功能界面</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#butt1").click(function () {
                
            })
        })
    </script>
</head>
<body>
    招聘管理
        <input id="butt1" type="button" value="应聘管理">
    部门管理
    职位管理
    员工管理
    薪资管理
    培训管理
    奖惩管理
    考勤管理
<table>
    <tr>
        <td>应聘者</td>
        <td>投递时间</td>
        <td>查看状态</td>
        <td>面试状态</td>
        <td colspan="2">操作</td>
    </tr>

    <tr>

    </tr>
</table>
</body>
</html>
