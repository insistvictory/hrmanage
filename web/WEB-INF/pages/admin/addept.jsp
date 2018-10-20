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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <script>
        $(function () {
            $("#btt").click(function () {
                var url = "${pageContext.request.contextPath}/admin/findDeptByName";
                var ags={name:$(":text").val()}
                $.post(url, args, function (data) {
                    if (data =="ok") {
                       alert("创建成功");
                    }else {
                        alert("此部门已存在")
                    }
                })
            })
        })
    </script>
</head>
<body>
    部门名称:<input type="text" name="name">
    <input id="btt" type="button" value="新建">
    <button><a href="${pageContext.request.contextPath}/admin/lookDepts">返回</a></button>
</body>
</html>
