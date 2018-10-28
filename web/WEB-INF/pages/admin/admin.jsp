<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/13
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <title>管理员功能界面</title>
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
            $("#d1").hide();
            $("#a1").click(function () {
                $("#d1").show();
                return false;
            });
            var date = new Date(); // new 一个Date对象
            var year = date.getFullYear(); // 年份
            /* var month = date.getMonth() + 1;*/ // 月份（从0开始，所以应+1）
            var month=12;
            for(var i = month; i > month-12; i--) {
                $("<option >" + year + "-" + i + "</option>").appendTo($("select")); // 依次添加下拉框选项，value自定义，右边的appendTo参数为目标选择框
            }
            $("select").blur(function () {
                $("#tb").empty();
                var str=""
                $.ajax({
                    url:"${pageContext.request.contextPath}/admin/lookRewardAndPublishByTime",
                    type:"post",
                    dataType:"json",
                    data:{"time":$(this).val()},
                    success:function(data){
                        $.each(data,function(idx,item){
                            str+="<tr>"+
                                "<td>"+item.eid+"</td>"
                                +"<td>"+item.cause+"</td>"
                                +"<td>"+item.rpTime+"</td>"
                                +"<td>"+item.money+"</td>"
                                +"</tr>"
                        });
                        $("<tr>"+
                            "<td>"+"奖惩人员"+"</td>"
                            +"<td>"+"奖惩缘由"+"</td>"
                            +"<td>"+"奖惩时间"+"</td>"
                            +"<td>"+"奖惩金额"+"</td>"
                            +"</tr>"

                        ).appendTo("#tb");
                        $(str).appendTo("#tb");
                    }
                })
            })
        })
    </script>
</head>
<body>
<div align="center">
    <a href="admin/lookApplications">应聘消息</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="admin/lookInterviews">面试消息</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="admin/lookDepts">部门管理</a><br>
    <hr size="5" noshade="noshade" width="100%">
    <a href="admin/lookAllEmployees">员工管理</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="admin/trainManage">培训管理</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="admin/lookAllSalaryMid">薪资管理</a><br>
    <hr size="5" noshade="noshade" width="100%">
    <a href="#" id="a1">奖惩管理</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="admin/lookAllArguments">工资异议</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="login.jsp">退出</a>
</div>
<div id="d1" align="center">
    <select></select>
    <table border="1px" cellspacing="0px" cellpadding="10px" id="tb">
    </table>
</div>
</body>
</html>
