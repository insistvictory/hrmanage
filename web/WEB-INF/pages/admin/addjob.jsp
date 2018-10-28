<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/20
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增相应部门的职位</title>
    <style type="text/css">
        body{
            background-image: url("${pageContext.request.contextPath}/img/5.jpg");
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-attachment: fixed;
        }
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <script>
        $(function () {
            $("#btt").click(function () {
                var url = "${pageContext.request.contextPath}/admin/findJobByName";
                var args={name:$(":text").val(),deptId:$("#hid").val()}
                $.post(url, args, function (data) {
                    if (data =="ok") {
                        alert("创建成功");
                    }else {
                        alert("此职位已存在")
                    }
                })
                return false;
            })
        })
    </script>
</head>
<body>
    <input type="hidden" value="${requestScope.deptId}" id="hid">
    职位名称:<input type="text" name="name">
    <button id="btt"><a href="#">新建</a> </button>
    <button><a href="${pageContext.request.contextPath}/admin/lookDepts">返回</a></button>
</body>
</html>
