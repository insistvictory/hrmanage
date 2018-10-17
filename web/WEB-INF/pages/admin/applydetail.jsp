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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $()
        })
    </script>
</head>
<body>
<form>
<table border="1" cellpadding="5px" cellspacing="0">
    <tr>
        <td colspan="4" align="center">简历</td>
    </tr>
    <tr>
        <td>姓名</td>
        <td><input type="text" name="name" value="${requestScope.resume.name}"></td>
        <td>性别</td>
        <td>
            <input type="text" name="gender" value="${requestScope.resume.gender}">
        </td>
    </tr>
    <tr>
        <td>年龄</td>
        <td><input type="text" name="age" value="${requestScope.resume.age}"></td>
        <td>学历</td>
        <td>
            <input type="text" name="education" value="${requestScope.resume.education}">
        </td>
    </tr>
    <tr>
        <td>联系方式</td>
        <td><input type="text" name="tel" value="${requestScope.resume.tel}"></td>
        <td>e-mail</td>
        <td><input type="text" name="email" value="${requestScope.resume.email}"></td>
    </tr>
    <tr>
        <td>应聘职位</td>
        <td>
            <input type="text" name="dept" value="${requestScope.resume.dept}">
            <input type="text" name="dept" value="${requestScope.resume.job}">
        </td>

        <td>政治面貌</td>
        <td>
            <input type="text" name="politicalStatus" value="${requestScope.resume.politicalStatus}">
        </td>
    </tr>
    <tr>
        <td>上份工作</td>
        <td><input type="text" name="lastJob" value="${requestScope.resume.lastJob}"></td>
        <td>工作经验</td>
        <td><input type="text" name="experience" value="${requestScope.resume.experience}"></td>
    </tr>
    <tr>
        <td>期望薪资</td>
        <td>
            <input type="text" name="salaryHope" value="${requestScope.resume.salaryHope}">
        </td>
        <td>兴趣爱好</td>
        <td><input type="text" name="hobby" value="${requestScope.resume.hobby}"></td>
    </tr>
    <tr>
        <td colspan="2" align="center"><input type="button" name="" id=""></td>
        <td colspan="2" align="center"><a href="${pageContext.request.contextPath}/admin/"></a>返回</td>
    </tr>
    <tr><input type="datetime" name="interviewTime"/>  <input id="sub" type="submit"></tr>
</table>
</form>
</body>
</html>
