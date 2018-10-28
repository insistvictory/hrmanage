<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/25
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员查看工资</title>
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
                    url:"${pageContext.request.contextPath}/admin/lookSalaryByTime",
                    type:"post",
                    dataType:"json",
                    data:{"time":$(this).val()},
                    success:function(data){
                        $.each(data,function(idx,item){
                            str+="<tr>"+
                                "<td>"+item.eid+"</td>"
                                +"<td>"+item.sumSalary+"</td>"
                                +"<td>"+item.baseSalary+"</td>"
                                +"<td>"+item.rewardSalary+"</td>"
                                +"<td>"+item.society+"</td>"
                                +"<td>"+item.argSalary+"</td>"
                                +"</tr>"
                        });
                        $("<tr>"+
                            "<td>"+"员工工号"+"</td>"
                            +"<td>"+"总工资"+"</td>"
                            +"<td>"+"基本工资"+"</td>"
                            +"<td>"+"奖惩工资"+"</td>"
                            +"<td>"+"社保"+"</td>"
                            +"<td>"+"异议工资"+"</td>"
                            +"</tr>"
                        ).appendTo("#tb");
                        $(str).appendTo("#tb")
                    }
                })
            })
        })
    </script>
</head>
<body>
<div align="center"style="margin-top:100px">
    <select></select>
    <table border="1px" cellspacing="0px" cellpadding="10px" id="tb">
    </table>
    <a href="${pageContext.request.contextPath}/admin/middle">返回</a>
</div>
</body>
</html>
