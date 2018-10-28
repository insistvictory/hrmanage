<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/19
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <title>员工管理</title>
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
            $("#tb1").hide();
            $("#tb2").hide();
            $("#sel").blur(function () {
                var str=$("#sel").val();
                if (str=='在职'){
                    $("#tb1").show();
                    $("#tb2").hide();
                }else {
                    $("#tb2").show();
                    $("#tb1").hide();
                }
            })
            $(".fire").click(function () {
                var $a=$(this);
                var url = "admin/fireEmployee";
                var $td = $(this).parent().parent().children();
                var id = $td[0].innerHTML;
                var args = {id: id}
                var flag = confirm("你确定要开除该员工？")
                if (flag) {
                    $.post(url, args, function (data) {
                        if (data=="ok") {
                            alert("为啥不删行啊")
                            $a.parent().parent().remove();
                        }
                    })
                }
                return false;
            })
            $(".hf1").click(function () {
                var $td=$(this).parent().parent().children();
                var url="${pageContext.request.contextPath}/admin/deliverSalary"
                var args={eid:$td[0].innerHTML}
                $.post(url,args,function (data) {
                    if(data=="re"){
                        alert("本月工资已经发放，不可重复发！")
                    }else if(data=="no"){
                        alert("请在25号之后发工资！")
                    }else {
                        alert("工资发放成功！")
                    }
                })
                return false;
            })
        })
    </script>
</head>
<body>
    <select name="sel" id="sel">
        <option>在职</option>
        <option>离职</option>
    </select>
    <table cellpadding="10px" cellspacing="0px" border="1px" id="tb1">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td colspan="4">操作</td>
        </tr>
        <c:forEach items="${requestScope.employees}" var="employee">
            <c:if test="${employee.nowStatus=='在职'}">
                <tr>
                    <td>${employee.id}</td>
                    <td><a href="admin/searchEmployeeById?id=${employee.id}">${employee.name}</a></td>
                    <td><a href="admin/transferOfPersonnel?id=${employee.id}">人事调动</a></td>
                    <td><a href="admin/findChecks?id=${employee.id}">考勤</a></td>
                    <td><a href="#" class="hf1">工资发放</a></td>
                    <td><a href="#" class="fire">开除</a></td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
    <table cellpadding="10px" cellspacing="0px" border="1px" id="tb2">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>入职时间</td>
        </tr>
        <c:forEach items="${requestScope.employees}" var="employee">
            <c:if test="${employee.nowStatus=='离职'}">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td><f:formatDate value="${employee.entryTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
    <a href="admin/middle">返回</a>
</body>
</html>
