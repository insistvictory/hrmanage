<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/19
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            $("#dd").hide();
            $("#aa").click(function () {
                $("#dd").show();
                return false;
            })
            $("#sub").click(function () {
                var url="${pageContext.request.contextPath}/admin/reward";
                var ags={cause:$("#cause").val(),money:$("#money").val(),rpTime:$("#time").val(),eid:${requestScope.employee.id}};
                $.post(url,ags,function (data) {
                    if (data=="yes"){
                        alert("赏罚成功!");
                    }
                })
                return false;
            })
        })
    </script>
</head>
<body>
 <table>
     <tr>
         <td colspan="4">员工信息</td>
     </tr>
     <tr>
         <td>姓名:</td>
         <td>${requestScope.employee.name}</td>
         <td>性别:</td>
         <td>${requestScope.employee.gender}</td>
     </tr>
     <tr>
         <td>年龄:</td>
         <td>${requestScope.employee.age}</td>
         <td>学历:</td>
         <td>${requestScope.employee.education}</td>
     </tr>
     <tr>
         <td>联系方式:</td>
         <td>${requestScope.employee.tel}</td>
         <td>邮箱:</td>
         <td>${requestScope.employee.email}</td>
     </tr>
     <tr>
         <td>入职时间:</td>
         <td><f:formatDate value="${requestScope.employee.entryTime}" pattern="yyyy-MM-dd hh:mm:ss"></f:formatDate></td>
         <td>职位:</td>
         <td>${requestScope.employee.dept}${requestScope.employee.job}</td>
     </tr>
 </table>
 <a href="#" id="aa">赏罚</a>
 <a href="${pageContext.request.contextPath}/admin/lookAllEmployees">返回</a>
<div id="dd">
    <table>
        <tr>
            <td colspan="2">赏罚</td></tr>
        <tr>
            <td>赏罚原因:</td>
            <td><input type="text" id="cause"></td>
        </tr>
        <tr>
            <td>赏罚金:</td>
            <td><input type="number" id="money"></td>
        </tr>
        <tr>
            <td>时间:</td>
            <td><input type="date" id="time"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="确认" id="sub"></td>
        </tr>
    </table>
</div>
</body>
</html>
