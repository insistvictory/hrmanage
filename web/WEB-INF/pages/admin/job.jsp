<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/16
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <title>部门管理</title>
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
            $(".del").click(function () {
                var $a = $(this);
                var $td = $(this).parent().parent().children();
                var name=$td[0].innerHTML;
                var url = "${pageContext.request.contextPath}/admin/deleteJobByName";
                var args = {"name":name};
                var flag=confirm("你确定要删除"+name+"职位吗？")
                if(flag){
                    $.post(url, args, function (data) {
                        if (data =="ok") {
                            $a.parent().parent().remove();
                        }else {
                            alert("该职位还有员工不能删除");
                        }
                    })
                }
                return false;
            })
        })
    </script>
</head>
<body>
<div align="center">
        <table border="1px" cellpadding="20px" cellspacing="0px">
            <tr>
                <td>职位</td>
                <td>删除</td>
                <td>修改</td>
            </tr>
            <c:forEach items="${requestScope.jobs}" var="job">
                <tr>
                    <td>${job.name}</td>
                    <td><a href="#" class="del">delete</a></td>
                    <td><a href="admin/lookJobDetail?id=${job.id}" class="eidt">edit</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="3"><a href="admin/addJobMiddle?deptId=${requestScope.deptId}">add</a></td>
            </tr>
        </table>
</div>
</body>
</html>
