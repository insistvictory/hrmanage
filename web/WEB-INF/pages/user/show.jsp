<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/12
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>游客界面</title>
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
            $("#dv").hide();
            if(${sessionScope.interview.readStatus=="未查看"}){
                alert("你有一份面试通知，详情请在反馈中查看")
            }
            $("#btt").click(function () {
                $("#dv").show();
                if (${sessionScope.interview.readStatus=="未查看"})
                var url="${pageContext.request.contextPath}/user/modifyInterview";
                var ags={readStatus:"已查看",id:${sessionScope.interview.id}};
                $.post(url,ags,function (data) {

                })
                return false;
            })
        })
    </script>
</head>
<body>
当前用户:${sessionScope.user.name}<br>
<a href="#" id="btt">反馈</a>
<a href="${pageContext.request.contextPath}/user/lookResume?flag=a&id=${sessionScope.user.id}">查看简历</a>
<a href="../../../modifypassword.jsp?id=${sessionScope.user.id}">修改密码</a>
<a href="${pageContext.request.contextPath}/login.jsp">退出</a>
<a href="${pageContext.request.contextPath}/user/lookAtRecruitInfo">查看招聘信息</a>
<hr/>
<div id="dv">
    <c:if test="${!empty sessionScope.interview}">
        <table border="1" cellpadding="5px" cellspacing="0">
            <tr>
                <td colspan="5" align="center">反馈</td>
            </tr>
            <tr>
                <td>投递时间</td>
                <td>是否查看</td>
                <td>是否面试</td>
                <td>面试时间</td>
                <td>是否录用</td>
            </tr>
            <tr>
                <td><f:formatDate value="${sessionScope.application.applyTime}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
                <td>${sessionScope.application.resumeStatus}</td>
                <td>${sessionScope.application.interviewStatus}</td>
                <td><f:formatDate value="${sessionScope.interview.interviewTime}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
                <td>${sessionScope.interview.hire}</td>
            </tr>
        </table>
    </c:if>
</div>
</body>
</html>

