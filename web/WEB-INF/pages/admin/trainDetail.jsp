<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/20
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <title>培训详情</title>
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
                var url = "${pageContext.request.contextPath}/admin/deleteTrainById";
                var args = {id:${requestScope.train.id}};
                var flag=confirm("你确定要删除吗？")
                if(flag){
                    $.post(url, args, function (data) {
                        if (data =="ok") {
                            alert("删除成功")
                        }
                    })
                }
                return false;
            })
        })
    </script>
    <style type="text/css">
        body{
            background-image: url("${pageContext.request.contextPath}/img/5.jpg");
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-attachment: fixed;
        }
    </style>
</head>
<body>
<form action="admin/updateTrain" method="post">
    <table>
        <input type="hidden" name="id" value="${requestScope.train.id}">
        <tr>
            <td colspan="2">培训---详情</td>
        </tr>
        <tr>
            <td>培训名称</td>
            <td><input type="text" name="trainContext" value="${requestScope.train.trainContext}"></td>
        </tr>
        <tr>
            <td>培训时间</td>
            <td><input type="date" name="trainTime" value="<f:formatDate value="${requestScope.train.trainTime}" pattern="yyyy-MM-dd"/>"></td>
        </tr>
        <tr>
            <td>培训时长</td>
            <td><input type="text" name="sumTime" value="${requestScope.train.sumTime}">天</td>
        </tr>
        <tr>
            <td>培训部门</td>
            <td>
                <select name="trainDept">
                    <c:forEach items="${requestScope.depts}" var="dept">
                        <c:if test="${requestScope.train.trainDept==dept.name}">
                            <option selected="selected">${dept.name}</option>
                        </c:if>
                        <c:if test="${requestScope.resume.dept!=dept.name}">
                            <option>${dept.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="修改"></td>
            <td><a href="#" class="del">删除</a></td>
        </tr>
        <tr>
            <td colspan="2"><a href="admin/trainManage">返回</a></td>
        </tr>
    </table>
</form>
</body>
</html>

