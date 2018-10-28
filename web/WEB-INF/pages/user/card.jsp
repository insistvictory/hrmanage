<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/12
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>简历表</title>
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
            $("#first").blur(function(){
                var deptName = $(this).val();
                $("#second").empty()
                var str=""
                $.ajax({
                    url:"${pageContext.request.contextPath}/user/findRelatedJobs",
                    type:"post",
                    dataType:"json",
                    data:{"dName":deptName},
                    success:function(data){
                        $.each(data,function(idx,item){
                            str+="<option>"+item.name+"</option>"
                        });
                        $(str).appendTo("#second")
                    }
                })
            })
            $(":submit").click(function () {
                if ($("#num").val()==""){
                    return false;
                }
            })
            $("#href").click(function () {
                if(${empty requestScope.resume}) {
                    alert("请先创建简历");
                }else {
                    var a='${requestScope.resume.id}';
                    var url="${pageContext.request.contextPath}/user/deliver";
                    var ags={resumeId:a};
                    $.post(url,ags,function (data) {
                        if (data=="yes"){
                            alert("投递成功");
                        }else {
                            alert("不可重复投递")
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
<form action="${pageContext.request.contextPath}/user/saveResume"method="post">

    <table border="1" cellpadding="5px" cellspacing="0">
        <tr>
            <td colspan="4" align="center">简历</td>
        </tr>
        <tr>
            <input type="hidden" name="uid" value="${sessionScope.user.id}">
            <td>真实姓名</td>
            <td><input type="text" name="name" value="${requestScope.resume.name}"></td>
            <td>性别</td>
            <td>
                ${requestScope.resume.gender eq '男'?'<input type="radio" name="gender" value="男" checked="checked"/>男':'<input type="radio" name="gender" value="男"/>男'}
                ${requestScope.resume.gender eq '女'?'<input type="radio" name="gender" value="女" checked="checked"/>女':'<input type="radio" name="gender" value="女"/>女'}
            </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input id="num" type="number" name="age" value="${requestScope.resume.age}"></td>
            <td>学历</td>
            <td>
                <select name="education">
                    <option <c:if test="${requestScope.resume.education == '高中'}">selected="selected"</c:if>>高中</option>
                    <option <c:if test="${requestScope.resume.education == '大专'}">selected="selected"</c:if>>大专</option>
                    <option <c:if test="${requestScope.resume.education == '本科'}">selected="selected"</c:if>>本科</option>
                    <option <c:if test="${requestScope.resume.education == '硕士'}">selected="selected"</c:if>>硕士</option>
                </select>
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
                <select id="first" name="dept">
                    <c:forEach items="${requestScope.depts}" var="dept">
                        <c:if test="${requestScope.resume.dept==dept.name}">
                            <option selected="selected">${dept.name}</option>
                        </c:if>
                        <c:if test="${requestScope.resume.dept!=dept.name}">
                            <option>${dept.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
                <select id="second" name="job">
                    <c:forEach items="${requestScope.jobs}" var="job">
                        <c:if test="${requestScope.resume.job==job.name}">
                            <option selected="selected">${job.name}</option>
                        </c:if>
                        <c:if test="${requestScope.resume.job!=job.name}">
                            <option>${job.name}</option>
                        </c:if>
                    </c:forEach>
                </select>

            </td>

            <td>政治面貌</td>
            <td>
                <select name="politicalStatus">
                    <option <c:if test="${requestScope.resume.politicalStatus == '群众'}">selected="selected"</c:if>>群众</option>
                    <option <c:if test="${requestScope.resume.politicalStatus == '团员'}">selected="selected"</c:if>>团员</option>
                    <option <c:if test="${requestScope.resume.politicalStatus == '党员'}">selected="selected"</c:if>>党员</option>
                </select>
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
                <select name=salaryHope>
                    <option <c:if test="${requestScope.resume.salaryHope == '3000-4000'}">selected="selected"</c:if>>3000-4000</option>
                    <option <c:if test="${requestScope.resume.salaryHope == '4000-6000'}">selected="selected"</c:if>>4000-6000</option>
                    <option <c:if test="${requestScope.resume.salaryHope == '6000-9000'}">selected="selected"</c:if>>6000-9000</option>
                    <option <c:if test="${requestScope.resume.salaryHope == '一万以上'}">selected="selected"</c:if>>一万以上</option>
                </select>
            </td>
            <td>兴趣爱好</td>
            <td><input type="text" name="hobby" value="${requestScope.resume.hobby}"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="保存"></td>

            <td colspan="2" align="center"><a href="${pageContext.request.contextPath}/user/lookResume?flag=b">返回</a></td>
        </tr>
    </table>
</form>
<a id="href" href="#">投递</a>
</div>

</body>
</html>
