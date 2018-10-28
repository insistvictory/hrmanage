<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/22
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
            url="${pageContext.request.contextPath}/admin/searchRelatedInterview";
            args={iid:${requestScope.iid}};
            $.post(url,args,function (data) {
                if(data=="ok"){
                    $(":submit").attr("disabled",true)
                    alert("此人以录用，不要重复录用")
                }
            })
        })
    </script>
</head>
<body>
${requestScope.resume.uid}用户id
<form action="${pageContext.request.contextPath}/admin/hireUser" method="post">
<table border="1" cellpadding="5px" cellspacing="0">
    <input type="hidden" name="iid" value="${requestScope.iid}">
    <input type="hidden" name="uid" value="${requestScope.resume.uid}">
    <tr>
        <td colspan="4" align="center">简历详情</td>
    </tr>
    <tr>
        <td>姓名</td>
        <td><input type="text" name="name" value="${requestScope.resume.name}" readonly="readonly"></td>
        <td>性别</td>
        <td>
            <input type="text" name="gender" value="${requestScope.resume.gender}"readonly="readonly">
        </td>
    </tr>
    <tr>
        <td>年龄</td>
        <td><input type="text" name="age" value="${requestScope.resume.age}" readonly="readonly"></td>
        <td>学历</td>
        <td>
            <input type="text" name="education" value="${requestScope.resume.education}" readonly="readonly">
        </td>
    </tr>
    <tr>
        <td>联系方式</td>
        <td><input type="text" name="tel" value="${requestScope.resume.tel}" readonly="readonly"></td>
        <td>e-mail</td>
        <td><input type="text" name="email" value="${requestScope.resume.email}" readonly="readonly"></td>
    </tr>
    <tr>
        <td>应聘职位</td>
        <td>
            <input type="text" name="dept" value="${requestScope.resume.dept}" readonly="readonly">
            <input type="text" name="job" value="${requestScope.resume.job}" readonly="readonly">
        </td>

        <td>政治面貌</td>
        <td>
            <input type="text" name="politicalStatus" value="${requestScope.resume.politicalStatus}" readonly="readonly">
        </td>
    </tr>
    <tr>
        <td>上份工作</td>
        <td><input type="text" name="lastJob" value="${requestScope.resume.lastJob}" readonly="readonly"></td>
        <td>工作经验</td>
        <td><input type="text" name="experience" value="${requestScope.resume.experience}" readonly="readonly"></td>
    </tr>
    <tr>
        <td>期望薪资</td>
        <td>
            <input type="text" name="salaryHope" value="${requestScope.resume.salaryHope}" readonly="readonly">
        </td>
        <td>兴趣爱好</td>
        <td><input type="text" name="hobby" value="${requestScope.resume.hobby}" readonly="readonly"></td>
    </tr>
    <tr>
        <td colspan="2" align="center"><input type="submit" value="录用"></td>
        <td colspan="2" align="center"><a href="${pageContext.request.contextPath}/admin/lookInterviews">返回</a></td>
    </tr>
</table>
</form>
</body>
</html>
