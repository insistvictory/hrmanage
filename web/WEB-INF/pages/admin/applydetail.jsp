<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/14
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查看投递者简历详情</title>
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
            $("#flag").hide();
            $("#hf").click(function () {
                $("#flag").show();
                return false;
            })
            var url="${pageContext.request.contextPath}/admin/findInterviewByApplyId";
            var args={applyId:${sessionScope.apid}}
            $.post(url,args,function (data) {
                if (data=="ok"){
                    $("#s1").attr("disabled",true);
                }
            })
        })
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/admin/interviewAdd" method="post">
    <input type="hidden" name="applyId" value="${sessionScope.apid}">
    <table border="1" cellpadding="5px" cellspacing="0">
        <tr>
            <td colspan="4" align="center">简历</td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name" value="${sessionScope.resume.name}" readonly="readonly"></td>
            <td>性别</td>
            <td>
                <input type="text" name="gender" value="${sessionScope.resume.gender}" readonly="readonly">
            </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age" value="${sessionScope.resume.age}" readonly="readonly"></td>
            <td>学历</td>
            <td>
                <input type="text" name="education" value="${sessionScope.resume.education}" readonly="readonly">
            </td>
        </tr>
        <tr>
            <td>联系方式</td>
            <td><input type="text" name="tel" value="${sessionScope.resume.tel}" readonly="readonly"></td>
            <td>e-mail</td>
            <td><input type="text" name="email" value="${sessionScope.resume.email}" readonly="readonly"></td>
        </tr>
        <tr>
            <td>应聘职位</td>
            <td>
                <input type="text" name="dept" value="${sessionScope.resume.dept}" readonly="readonly">
                <input type="text" name="job" value="${sessionScope.resume.job}" readonly="readonly">
            </td>

            <td>政治面貌</td>
            <td>
                <input type="text" name="politicalStatus" value="${sessionScope.resume.politicalStatus}" readonly="readonly">
            </td>
        </tr>
        <tr>
            <td>上份工作</td>
            <td><input type="text" name="lastJob" value="${sessionScope.resume.lastJob}" readonly="readonly"></td>
            <td>工作经验</td>
            <td><input type="text" name="experience" value="${sessionScope.resume.experience}" readonly="readonly"></td>
        </tr>
        <tr>
            <td>期望薪资</td>
            <td>
                <input type="text" name="salaryHope" value="${sessionScope.resume.salaryHope}" readonly="readonly">
            </td>
            <td>兴趣爱好</td>
            <td><input type="text" name="hobby" value="${sessionScope.resume.hobby}" readonly="readonly"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><a id="hf" href="#">面试</a></td>
            <td colspan="2" align="center"><a href="${pageContext.request.contextPath}/admin/lookApplications">返回</a></td>
        </tr>
        <tr id="flag">
            <td colspan="2">
                <input type="date" name="interviewTime"/>
            </td>
            <td colspan="2">
                <input  type="submit" value="确认" id="s1">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
