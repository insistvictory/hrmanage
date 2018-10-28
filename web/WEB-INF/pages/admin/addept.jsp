<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/18
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加部门</title>
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
                var url = "${pageContext.request.contextPath}/admin/findDeptByName";
                var args={name:$(":text").val()}
                $.post(url, args, function (data) {
                    if (data =="ok") {
                       alert("创建成功");
                    }else {
                        alert("此部门已存在")
                    }
                })
                return false;
            })
        })
    </script>
</head>
<body>
    部门名称:<input type="text" name="name">
    <button id="btt"><a href="#">新建</a> </button>
    <button><a href="${pageContext.request.contextPath}/admin/lookDepts">返回</a></button>
</body>
</html>
