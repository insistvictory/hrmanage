<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/25
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工查看自己的工资</title>
    <style type="text/css">
        body{
            background-image: url("${pageContext.request.contextPath}/img/5.jpg");
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-attachment: fixed;
        }
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            var date = new Date(); // new 一个Date对象
            var year = date.getFullYear(); // 年份
            /* var month = date.getMonth() + 1;*/ // 月份（从0开始，所以应+1）
            var month=12;
            for(var i = month; i > month-12; i--) {
                $("<option >" + year + "-" + i + "</option>").appendTo($("select")); // 依次添加下拉框选项，value自定义，右边的appendTo参数为目标选择框
            }
        })
    </script>
</head>
<body>
<div align="center"style="margin-top:100px">
    <form action="${pageContext.request.contextPath}/employee/lookSalaryByTime" method="post"><input type="hidden" name="eid" value="${requestScope.eid}">
    <select name="time"></select>
    <input type="submit">
    </form>
</div>
</body>
</html>
