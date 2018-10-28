<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/19
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>人事调动</title>
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
            $("#sub").click(function () {
                var url="${pageContext.request.contextPath}/admin/transfer";
                var ags={dept:$("#first").val(),job:$("#second").val(),id:${requestScope.employee.id}};
                $.post(url,ags,function (data) {
                    if (data=="yes"){
                        alert("调度成功")
                    }
                })
                return false;
            })
        })
    </script>
</head>
<body>
    <h2>请选择</h2>
    <select name="dept" id="first">
        <c:forEach items="${requestScope.depts}" var="dept">
            <c:if test="${requestScope.employee.dept==dept.name}">
                <option selected="selected">${dept.name}</option>
            </c:if>
            <c:if test="${requestScope.employee.dept!=dept.name}">
                <option>${dept.name}</option>
            </c:if>
        </c:forEach>
    </select>
    <select id="second" name="job">
        <c:forEach items="${requestScope.jobs}" var="job">
            <c:if test="${requestScope.employee.job==job.name}">
                <option selected="selected">${job.name}</option>
            </c:if>
            <c:if test="${requestScope.employee.job!=job.name}">
                <option>${job.name}</option>
            </c:if>
        </c:forEach>
    </select>
    <input type="submit" value="确认调动" id="sub">
    <a href="${pageContext.request.contextPath}/admin/lookAllEmployees">返回</a>
</body>
</html>
