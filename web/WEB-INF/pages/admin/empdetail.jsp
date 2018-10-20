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
                var ags={cause:$("#cause").val(),money:$("#money").val(),time:$("#time").val(),id:${requestScope.employee.id}};
                $.post(url,ags,function (data) {
                    if (data=="yes"){

                    }else {

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
 <a href="#" id="aa">奖赏</a>
 <a href="${pageContext.request.contextPath}/admin/lookAllEmployees">返回</a>
<div id="dd">
    <table>
        <tr>
            <td colspan="2">奖赏</td></tr>
        <tr>
            <td>奖赏原因:</td>
            <td id="cause"><input type="text"></td>
        </tr>
        <tr>
            <td>奖金:</td>
            <td id="money"><input type="number"></td>
        </tr>
        <tr>
            <td>时间:</td>
            <td id="time"><input type="date"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="确认" id="sub"></td>
        </tr>
    </table>
</div>
</body>
</html>
