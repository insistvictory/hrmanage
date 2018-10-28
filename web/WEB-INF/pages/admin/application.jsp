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
    <title>应聘消息</title>
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
                var id=$td[0].innerHTML;
                var url = "${pageContext.request.contextPath}/admin/deleteApplicationById";
                var args = {"id":id};
                var flag=confirm("你确定要删除"+id+"号应聘者的信息吗？")
                if(flag){
                    $.post(url, args, function (data) {
                        if (data =="ok") {
                            $a.parent().parent().remove();
                        }else {
                            alert("邀请面试记录生成，此申请暂不能删");
                        }
                    })
                }
                return false;
            })
        })
    </script>
</head>
<body>
    <div>
        <table border="1px" cellpadding="5px" cellspacing="0px">
            <tr>
                <td>应聘者</td>
                <td>投递时间</td>
                <td>查看状态</td>
                <td>面试状态</td>
                <td colspan="2">操作</td>
            </tr>
                <c:forEach items="${sessionScope.applications}" var="application">
                    <tr>
                        <td>${application.id}</td>
                        <td><f:formatDate value="${application.applyTime}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
                        <td>${application.resumeStatus}</td>
                        <td>${application.interviewStatus}</td>
                        <td><a href="admin/searchDelivererDetail?id=${application.resumeId}&apid=${application.id}">查看</a></td>
                        <td><a href="#" class="del">删除</a></td>
                    </tr>
                </c:forEach>
        </table>
        <a href="admin/middle">返回</a>
    </div>
</body>
</html>
